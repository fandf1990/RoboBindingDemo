package org.robobind.tuku.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class ZoomImageView extends ImageViewTouch {
    private Context mContext;

    public ZoomImageView(Context context) {
        super(context, null);
    }


    public ZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public void setImageUrl(String url) {
        Glide.with(mContext).load(url)
                .into(this);
        System.out.println("url "+url);
    }

    public void setImageRes(Integer resId) {
        Glide.with(mContext).load(resId).into(this);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

}
