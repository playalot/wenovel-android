package szu.whale.wenote.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.hyx.whale.whalenote.R;

import java.io.File;

/**
 * description:
 * author：xujianye
 * date: 2017/1/19 0019 10:56
 * email：jianyexu@hyx.com
 */
public class GlideRequest implements ImageLoaderListener {

    private Context mContext;
    private int mProgressId = -1, mErrorId = -1;

    public GlideRequest(Context context) {
        mContext = context;
    }

    public GlideRequest(Context context, int progressId, int errorId) {
        mContext = context;
        mProgressId = progressId;
        mErrorId = errorId;
    }

    @Override
    public void display(ImageView imageView, String url, int progressId, int errorId) {
        DrawableTypeRequest<String> load = Glide.with(mContext).load(url);
        if (progressId != -1) {
            load.placeholder(progressId).centerCrop();
        } else if (mProgressId != -1) {
            load.placeholder(mProgressId);
        } else {
            load.placeholder(R.drawable.default_loadding);
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
    public void display(ImageView imageView, String url, int progressId) {
        display(imageView, url, progressId, -1);
    }

    @Override
    public void display(ImageView imageView, String url) {
        display(imageView, url, -1);
    }

    @Override
    public void display(ImageView imageView, int resId) {
        DrawableTypeRequest<Integer> load = Glide.with(mContext).load(resId);
        load.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    @Override
    public void display(ImageView imageView, File file) {
        DrawableTypeRequest<File> load = Glide.with(mContext).load(file);
        load.diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    @Override
    public void display(ImageView imageView, Uri uri) {
        DrawableTypeRequest<Uri> load = Glide.with(mContext).load(uri);
        load.into(imageView);
    }

    @Override
    public void display(final ImageView imageView, final String url, final ImageListener listener) {
        if (listener == null) {
            return;
        }

        DrawableTypeRequest<String> load = Glide.with(mContext).load(url);

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
    public void display(String url, ImageListener listener) {
        display(null, url, listener);
    }

    @Override
    public Bitmap getBitmapSync(String url) throws Exception {

        Bitmap bitmap = Glide.with(mContext)
                .load(url)
                .asBitmap()
                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .get();

        return bitmap;
    }
}