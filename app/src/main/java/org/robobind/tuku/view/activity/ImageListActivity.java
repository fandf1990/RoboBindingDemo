package org.robobind.tuku.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vlonjatg.progressactivity.ProgressActivity;

import org.robobind.demo.R;
import org.robobind.tuku.base.AbstractActivity;
import org.robobind.tuku.model.ImageListPresentationModel;


public class ImageListActivity extends AbstractActivity {


    private ProgressActivity mProgressActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageListPresentationModel imageListPresentationModel = new ImageListPresentationModel(this);
        initializeContentView(R.layout.image_list_activity,imageListPresentationModel);
        mProgressActivity = (ProgressActivity) findViewById(R.id.image_list_progress_activity);
        imageListPresentationModel.loadImagePath();

//        mProgressActivity.showLoading();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mProgressActivity.showContent();
//            }
//        },2000);
    }

    public void imageLoading(){
        mProgressActivity.showLoading();
    }
    public void imageLoadFinish(){
        mProgressActivity.showContent();
    }



}
