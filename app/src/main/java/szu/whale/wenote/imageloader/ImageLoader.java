package szu.whale.wenote.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

import szu.whale.wenote.imageloader.GlideStrategy.GlideImageLoaderStrategy;

/**
 * description:
 * author：whale
 * date: 2017/1/19 0019 10:57
 * email：whale@hyx.com
 */
public class ImageLoader {

    //图片默认加载类型
    public static final int LOAD_PIC_DEFAULT_TYPE = 0;
    //图片默认加载类型
    public static final int LOAD_PIC_GLIDE = 0;

    public int currentLoadType = 0;
    //单例模式
    private static ImageLoader imageLoader;
    private static BaseImageLoaderStrategy baseImageLoaderStrategy;

    private static int mProgressId, mErrorId;


    public static ImageLoader getInstance(){
        if(null==imageLoader) {
            synchronized (ImageLoader.class) {
                if (null == imageLoader) {
                    imageLoader = new ImageLoader();
                }
            }
        }
        return imageLoader;
    }

    private ImageLoader(){
        switch (currentLoadType) {
            case LOAD_PIC_DEFAULT_TYPE:
                baseImageLoaderStrategy = getBaseImageLoaderStrategy();
                return;
            default:
                baseImageLoaderStrategy = getBaseImageLoaderStrategy();
                return;
        }
    }

    /*
    * 在这里设置图片加载库的类型
    * */
    private static BaseImageLoaderStrategy getBaseImageLoaderStrategy() {
        if (baseImageLoaderStrategy == null) {
            synchronized (ImageLoader.class) {
                if (baseImageLoaderStrategy == null) {
                    baseImageLoaderStrategy = new GlideImageLoaderStrategy();
                }
            }
        }
        return baseImageLoaderStrategy;
    }

    //设置图片加载过程中的图
    public void setImgProgressId(int progressId) {
        mProgressId = progressId;
    }

    //设置图片加载错误显示的图片
    public void setImgErrorId(int errorId) {
        mErrorId = errorId;
    }

    /**
     * 无holder的gif加载
     *
     * @param url
     * @param imageView
     */
    public void display(ImageView imageView, String url) {
        baseImageLoaderStrategy.display(imageView, url);
    }


    public void display(ImageView imageView, String url, int progressId, int errorId) {
        baseImageLoaderStrategy.display(imageView, url, progressId , errorId);
    }

    public void displayCircleImg(ImageView imageView, String url, int progressId) {
        baseImageLoaderStrategy.displayCircleImg(imageView , url , progressId);
    }

    public void displayCircleImgBorder(ImageView imageView, String url, int progressId, int errorId, int borderColor , float borderWidth) {
        baseImageLoaderStrategy.displayCircleImgBorder(imageView , url , progressId , errorId , borderColor , borderWidth);
    }


    public void display(ImageView imageView, String url, int progressId) {
        baseImageLoaderStrategy.display(imageView , url , progressId);
    }


    public void display(ImageView imageView, int resId) {
        baseImageLoaderStrategy.display(imageView , resId);
    }

    public void display(ImageView imageView, File file) {
        baseImageLoaderStrategy.display(imageView , file);
    }

    public void display(ImageView imageView, Uri uri) {
        baseImageLoaderStrategy.display(imageView , uri);
    }

    public void displayGifImage(ImageView imageView, String uri, int progressId) {
        baseImageLoaderStrategy.displayGifImage(imageView, uri , progressId);
    }


    public void display(final ImageView imageView, final String url, final ImageLoaderListener listener) {
        baseImageLoaderStrategy.display(imageView , url , listener);
    }

    public void display(String url, ImageLoaderListener listener) {
        baseImageLoaderStrategy.display(null, url, listener);
    }

    public Bitmap getBitmapSync(Context context , String url) throws Exception {
        return baseImageLoaderStrategy.getBitmapSync(context , url);
    }


    //主线程和子线程都可以执行
    public void clearImageDiskCache(final Context context) {
        baseImageLoaderStrategy.clearImageDiskCache(context);
    }

    //只能在主线程执行
    public void clearMemoryCache(Context context) {
        baseImageLoaderStrategy.clearMemoryCache(context);
    }


    public void trimMemory(Context context , int level){
        baseImageLoaderStrategy.trimMemory(context , level);
    }

    public void saveImage(Context context, String url, String filePath, String fileName, ImageSaveListener imageSaveListener) {
        baseImageLoaderStrategy.saveImage(context , url , filePath , fileName , imageSaveListener);
    }

}
