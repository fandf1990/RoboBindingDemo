package org.robobind.tuku.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GlideImageView extends ImageView {

    private Context mContext;

    public GlideImageView(Context context) {
        this(context, null);
    }

    public GlideImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public void setImageUrl(String url) {
        Glide.with(mContext).load(url).centerCrop()
                .into(this);
    }

    public void setImageRes(Integer resId) {
        Glide.with(mContext).load(resId).into(this);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

}
