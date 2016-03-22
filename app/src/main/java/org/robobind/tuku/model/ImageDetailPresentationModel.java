package org.robobind.tuku.model;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

@PresentationModel
public class ImageDetailPresentationModel implements HasPresentationModelChangeSupport {

    private PresentationModelChangeSupport modelChangeSupport;
    private String mImageUrl;

    public ImageDetailPresentationModel(String url) {
        this.mImageUrl = url;
        modelChangeSupport = new PresentationModelChangeSupport(this);
    }

    public void loadLargeImage(String url) {
        this.mImageUrl = url;
        modelChangeSupport.firePropertyChange("imageUrl");
    }

    public String getImageUrl() {
        System.out.println("imageUrl "+mImageUrl);
        return mImageUrl;
    }


    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return modelChangeSupport;
    }
}
