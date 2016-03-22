package org.robobind.tuku.base;

import android.support.v4.app.Fragment;
import android.view.View;

import org.robobind.tuku.TukuApplication;
import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;

public class AbstractFragment extends Fragment {

    protected View mRootView;

    public View initializeFragmentView(int layoutId, Object presentationModel) {
        ViewBinder viewBinder = createViewBinder();
        mRootView= viewBinder.inflateAndBind(layoutId, presentationModel);
        return mRootView;
    }

    public ViewBinder createViewBinder(){
        BinderFactory binderFactory = TukuApplication.getInstance().getReusableBinderFactory();
        return binderFactory.createViewBinder(getActivity());
    }




}
