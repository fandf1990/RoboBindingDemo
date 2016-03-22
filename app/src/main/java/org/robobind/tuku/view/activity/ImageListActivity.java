package org.robobind.tuku.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.robobind.demo.R;
import org.robobind.tuku.base.AbstractActivity;
import org.robobind.tuku.model.ImageListPresentationModel;


public class ImageListActivity extends AbstractActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageListPresentationModel imageListPresentationModel = new ImageListPresentationModel(this);
        initializeContentView(R.layout.image_list_activity,imageListPresentationModel);
        imageListPresentationModel.loadImagePath();
    }




}
