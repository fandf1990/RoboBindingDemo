package org.robobind.tuku;

import android.app.Application;

import org.robobind.tuku.view.widget.GlideImageView;
import org.robobind.tuku.view.widget.Pinch2ImageView;
import org.robobind.tuku.view.widget.SquareImageView;
import org.robobind.tuku.view.widget.ZoomImageView;
import org.robobind.tuku.view.widget.bind.GlideImageBinding;
import org.robobind.tuku.view.widget.bind.Pinch2ImageBinding;
import org.robobind.tuku.view.widget.bind.SquareImageBinding;
import org.robobind.tuku.view.widget.bind.ZoomImageBinding;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;


public class TukuApplication extends Application {

    private BinderFactory reusableBinderFactory;
    private static TukuApplication mTukuApp;

    @Override
    public void onCreate() {
        super.onCreate();
        reusableBinderFactory = new BinderFactoryBuilder()
                .add(new GlideImageBinding().extend(GlideImageView.class))
                .add(new SquareImageBinding().extend(SquareImageView.class))
                .add(new ZoomImageBinding().extend(ZoomImageView.class))
                .add(new Pinch2ImageBinding().extend(Pinch2ImageView.class))
                .build();
        mTukuApp = this;
    }

    public static TukuApplication getInstance() {
        return mTukuApp;
    }

    public BinderFactory getReusableBinderFactory() {
        return reusableBinderFactory;
    }


}
