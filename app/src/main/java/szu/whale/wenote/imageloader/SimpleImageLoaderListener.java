package szu.whale.wenote.imageloader;

import android.graphics.Bitmap;
import android.view.View;

/**
 * description:
 * author：whale
 * date: 2017/2/14 0014 15:07
 * email：whale@hyx.com
 */
public class SimpleImageLoaderListener implements ImageLoaderListener {

    @Override
    public void onLoadingStarted(String imageUri, View view) {

    }

    @Override
    public void onLoadingFailed(String imageUri, View view, Exception e) {

    }

    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

    }

    @Override
    public void onLoadingCancelled(String imageUri, View view) {

    }
}
