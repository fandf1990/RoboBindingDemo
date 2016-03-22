package org.robobind.tuku.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import com.boycy815.pinchimageview.PinchImageView;
import com.bumptech.glide.Glide;

public class Pinch2ImageView extends PinchImageView {
    private Context mContext;
    public Pinch2ImageView(Context context) {
        super(context,null);
    }

    public Pinch2ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public void setImageUrl(String url) {
        Glide.with(mContext).load(url)
                .into(this);
    }

    public void setImageRes(Integer resId) {
        Glide.with(mContext).load(resId).into(this);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }
}
