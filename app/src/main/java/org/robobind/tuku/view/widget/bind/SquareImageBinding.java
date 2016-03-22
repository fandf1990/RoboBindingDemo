package org.robobind.tuku.view.widget.bind;


import org.robobind.tuku.view.widget.SquareImageView;
import org.robobinding.annotation.ViewBinding;
import org.robobinding.customviewbinding.CustomViewBinding;

@ViewBinding(simpleOneWayProperties = {"imageBitmap","imageUrl","imageRes"/*when it is bitmap*/})
public class SquareImageBinding extends CustomViewBinding<SquareImageView> {
}