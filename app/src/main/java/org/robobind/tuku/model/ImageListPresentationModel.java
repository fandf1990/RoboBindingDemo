package org.robobind.tuku.model;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;

import org.robobind.tuku.mapping.ImageListItemValueModel;
import org.robobind.tuku.view.activity.ImageDetailActivity;
import org.robobind.tuku.view.activity.ImageListActivity;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;
import org.robobinding.widget.adapterview.ItemClickEvent;

import java.util.ArrayList;
import java.util.List;

@PresentationModel
public class ImageListPresentationModel implements HasPresentationModelChangeSupport {

    private PresentationModelChangeSupport modelChangeSupport;
    private ArrayList<String> mPhotoPathList;
    private ImageListActivity mViewActivity;

    public ImageListPresentationModel(ImageListActivity context) {
        this.mViewActivity = context;
        modelChangeSupport = new PresentationModelChangeSupport(this);
        mPhotoPathList = new ArrayList<>();
    }

    public void loadImagePath() {
        mViewActivity.imageLoading();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = mViewActivity.getContentResolver();
        Cursor mCursor = contentResolver.query(uri, null, MediaStore.Images.Media.MIME_TYPE + "=? or "
                        + MediaStore.Images.Media.MIME_TYPE + "=?", new String[]{"image/jpeg", "image/png"},
                MediaStore.Images.Media.DATE_MODIFIED);
        while (mCursor.moveToNext()) {
            //获取图片的路径
            String path = mCursor.getString(mCursor
                    .getColumnIndex(MediaStore.Images.Media.DATA));
            mPhotoPathList.add(path);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewActivity.imageLoadFinish();
            }
        }, 100);
        //mViewActivity.imageLoadFinish();
    }


    @ItemPresentationModel(value = ImageListItemValueModel.class)
    public List<String> getPhotoPathList() {
        return mPhotoPathList;
    }


    public void viewProduct(ItemClickEvent event) {
        Intent intent = new Intent(mViewActivity, ImageDetailActivity.class);
        intent.putStringArrayListExtra(ImageDetailActivity.IMAGE_URL_LIST, mPhotoPathList);
        intent.putExtra(ImageDetailActivity.IMAGE_INDEX, event.getPosition());
        mViewActivity.startActivity(intent);
    }


    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return modelChangeSupport;
    }


}
