package org.robobind.tuku.mapping;


import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;


public class ImageListItemValueModel implements ItemPresentationModel<String> {

    private String imagePath;

    @Override
    public void updateData(String s, ItemContext itemContext) {
        this.imagePath = s;
    }

    public String getImagePath(){
        return imagePath;
    }
}
