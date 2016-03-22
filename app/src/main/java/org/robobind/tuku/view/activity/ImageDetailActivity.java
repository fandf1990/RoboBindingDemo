package org.robobind.tuku.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import org.robobind.demo.R;
import org.robobind.tuku.base.AbstractActivity;
import org.robobind.tuku.view.fragment.ImageDetailFragment;

import java.util.List;


public class ImageDetailActivity extends AbstractActivity {

    public final static String IMAGE_URL_LIST = "image_url_list";
    public final static String IMAGE_INDEX = "image_index";

    private ViewPager mViewPager;
    private List<String> mImageUrlList;
    private int mImageIndex;
    private int mTotalSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mImageUrlList = intent.getStringArrayListExtra(IMAGE_URL_LIST);
        mTotalSize = mImageUrlList.size();
        mImageIndex = intent.getIntExtra(IMAGE_INDEX, 0);
        setContentView(R.layout.image_detail_activity);
        mViewPager = (ViewPager) findViewById(R.id.image_detail_viewpager);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mImageUrlList.size();
            }

            @Override
            public Fragment getItem(int index) {
                return ImageDetailFragment.newInstance(mImageUrlList.get(index));
            }
        });

        mViewPager.setCurrentItem(mImageIndex);

    }
}
