package szu.whale.wenote.imageloader;

import android.graphics.Bitmap;
import android.view.View;

/**
 * description:
 * author：whale
 * date: 2017/2/14 0014 14:51
 * email：whale@hyx.com
 */
public interface ImageLoaderListener {

    /**
     * Is called when image loading task was started
     *
     * @param imageUri Loading image URI
     * @param view     View for image
     */
    void onLoadingStarted(String imageUri, View view);

    /**
     * Is called when an error was occurred during image loading
     *
     * @param imageUri   Loading image URI
     * @param view       View for image. Can be <b>null</b>.
     * @param e The reason why imageloading was failed
     */
    void onLoadingFailed(String imageUri, View view, Exception e);

    /**
     * Is called when image is loaded successfully (and displayed in View if one was specified)
     *
     * @param imageUri    Loaded image URI
     * @param view        View for image. Can be <b>null</b>.
     * @param loadedImage Bitmap of loaded and decoded image
     */
    void onLoadingComplete(String imageUri, View view, Bitmap loadedImage);

    /**
     * Is called when image loading task was cancelled because View for image was reused in newer task
     *
     * @param imageUri Loading image URI
     * @param view     View for image. Can be <b>null</b>.
     */
    void onLoadingCancelled(String imageUri, View view);
}
