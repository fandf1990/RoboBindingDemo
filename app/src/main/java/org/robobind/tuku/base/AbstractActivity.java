package org.robobind.tuku.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.robobind.tuku.TukuApplication;
import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;


public class AbstractActivity extends AppCompatActivity {

    public void initializeContentView(int layoutId, Object presentationModel) {
        ViewBinder viewBinder = createViewBinder();
        View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
        setContentView(rootView);
    }

    public ViewBinder createViewBinder(){
        BinderFactory binderFactory = TukuApplication.getInstance().getReusableBinderFactory();
        return binderFactory.createViewBinder(this);
    }



}
