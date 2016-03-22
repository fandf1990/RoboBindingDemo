package org.robobind.tuku.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.robobind.demo.R;
import org.robobind.tuku.base.AbstractFragment;
import org.robobind.tuku.model.ImageDetailPresentationModel;



public class ImageDetailFragment extends AbstractFragment {

    public static final String EXTRA_IMAGE_URL = "view.widget.fragment.ImageDetailFragment.imageUrl";

    private ImageDetailPresentationModel imageDetailPresentationModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String imageUrl = getArguments().getString(EXTRA_IMAGE_URL);
        imageDetailPresentationModel = new ImageDetailPresentationModel(imageUrl);
    }

    public static ImageDetailFragment newInstance(String imageUrl) {
        Bundle args = new Bundle();
        args.putString(EXTRA_IMAGE_URL, imageUrl);
        ImageDetailFragment fragment = new ImageDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initializeFragmentView(R.layout.image_detail_fragment,imageDetailPresentationModel);
    }
}
