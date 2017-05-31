package szu.whale.wenote.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;

import szu.whale.wenote.R;

/**
 * description:
 * author：whale
 * date: 2017/1/19 0019 10:56
 * email：whale@hyx.com
 */
public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy {

    private int mProgressId = -1, mErrorId = -1;

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
    @Override
    public void display(ImageView imageView, String url) {
        display(imageView, url, -1);
    }


    @Override
    public void display(ImageView imageView, String url, int progressId, int errorId) {
        DrawableTypeRequest<String> load = Glide.with(imageView.getContext()).load(url);
        if (progressId != -1) {
            load.placeholder(progressId).centerCrop();
        } else if (mProgressId != -1) {
            load.placeholder(mProgressId);
        } else {
            load.placeholder(R.drawable.img_default_loading);
        }
        if (errorId != -1) {
            load.error(errorId);
        } else if (mErrorId != -1) {
            load.error(mErrorId);
        } else {
//            load.error(R.drawable.ic_error);
        }
        load.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    @Override
    public void displayCircleImg(ImageView imageView, String url, int progressId) {
        Glide.with(imageView.getContext()).load(url).placeholder(progressId).dontAnimate()
                .transform(new GlideCircleTransform(imageView.getContext()))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
    }

    @Override
    public void displayCircleImgBorder(ImageView imageView, String url, int progressId, int errorId, int borderColor , float borderWidth) {
        Glide.with(imageView.getContext()).load(url).placeholder(progressId).error(errorId).dontAnimate()
                .transform(new GlideCircleTransform(imageView.getContext(), borderWidth , borderColor))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
    }


    @Override
    public void display(ImageView imageView, String url, int progressId) {
        display(imageView, url, progressId, -1);
    }
    @Override
    public void display(ImageView imageView, int resId) {
        DrawableTypeRequest<Integer> load = Glide.with(imageView.getContext()).load(resId);
        load.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    @Override
    public void display(ImageView imageView, File file) {
        DrawableTypeRequest<File> load = Glide.with(imageView.getContext()).load(file);
        load.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    @Override
    public void display(ImageView imageView, Uri uri) {
        DrawableTypeRequest<Uri> load = Glide.with(imageView.getContext()).load(uri);
        load.into(imageView);
    }

    @Override
    public void displayGifImage(ImageView imageView, String uri, int progressId) {
        displayGif(imageView.getContext(), uri , progressId , imageView);
    }

    private void displayGif(Context context, String url , int progressId, ImageView imageView) {
        final long startTime = System.currentTimeMillis();
        Glide.with(context).load(url).asGif().placeholder(progressId).skipMemoryCache(true).dontAnimate().diskCacheStrategy(DiskCacheStrategy.SOURCE).listener(new RequestListener<String, GifDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(imageView);
    }

    @Override
    public void display(final ImageView imageView, final String url, final ImageLoaderListener listener) {
        if (listener == null) {
            return;
        }

        DrawableTypeRequest<String> load = Glide.with(imageView.getContext()).load(url);

        load.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .crossFade();

        load.asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                if (imageView != null) {
                    imageView.setImageBitmap(resource);
                }
                listener.onLoadingComplete(url, imageView, resource);
            }

            @Override
            public void onLoadCleared(Drawable placeholder) {
                listener.onLoadingCancelled(url, imageView);
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                listener.onLoadingFailed(url, imageView, e);
            }

            @Override
            public void onLoadStarted(Drawable placeholder) {
                listener.onLoadingStarted(url, imageView);
            }
        });
    }

    @Override
    public void display(String url, ImageLoaderListener listener) {
        display(null, url, listener);
    }

    @Override
    public Bitmap getBitmapSync(Context context , String url) throws Exception {
        Bitmap bitmap = Glide.with(context)
                .load(url)
                .asBitmap()
                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .get();
        return bitmap;
    }


    //主线程和子线程都可以执行
    @Override
    public void clearImageDiskCache(final Context context) {
        try{
            if(Looper.myLooper() == Looper.getMainLooper()){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context.getApplicationContext()).clearDiskCache();
                    }
                }).start();

            }
            else{
                Glide.get(context.getApplicationContext()).clearDiskCache();
            }
        }catch (Exception e){

        }
    }

    //只能在主线程执行
    @Override
    public void clearMemoryCache(Context context) {
        try {
            if(Looper.getMainLooper() == Looper.getMainLooper()){
                Glide.get(context.getApplicationContext()).clearMemory();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void trimMemory(Context context , int level){
        Glide.get(context).trimMemory(level);
    }

    @Override
    public void saveImage(Context context, String url, String filePath, String fileName, ImageSaveListener imageSaveListener) {

    }
}