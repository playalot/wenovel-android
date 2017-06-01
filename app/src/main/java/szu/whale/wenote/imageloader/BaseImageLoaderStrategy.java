package szu.whale.wenote.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * description:
 * author：whale
 * date: 2017/1/19 0019 10:55
 * email：whale@hyx.com
 */
public interface BaseImageLoaderStrategy {

    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param url 图片地址
     */
    void display(ImageView imageView, String url);


    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param url 图片地址（url、path、resourceId）
     * @param progressId 加载中显示的图片
     */
    void display(ImageView imageView, String url, int progressId);

    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param url 图片地址（url、path、resourceId）
     * @param progressId 加载中显示的图片
     * @param errorId 加载失败显示的图片
     */
    void display(ImageView imageView, String url, int progressId, int errorId);
    /**
     * 加载圆角图片
     * @param imageView 显示的view
     * @param url
     * @param progressId
     */
    void displayCircleImg(ImageView imageView, String url , int progressId);

    /**
     * 加载圆角图片
     * @param imageView   显示的view
     * @param url         当前ui
     * @param progressId  正在加载中的显示图
     * @param errorId     错误加载显示的图片
     * @param borderWidth 圆角边界的圆角角度
     * @param borderColor 圆角边界的边界颜色
     */
    public void displayCircleImgBorder(ImageView imageView, String url, int progressId, int errorId, int borderColor , float borderWidth);
    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param resId 资源id
     */
    void display(ImageView imageView, int resId);

    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param file 文件路径
     */
    void display(ImageView imageView, File file);

    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param uri 图片地址URI
     */
    void display(ImageView imageView, Uri uri);

    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param url 图片地址（url、path、resourceId）
     * @param listener 加载完成回调接口
     */
    void display(ImageView imageView, String url, ImageLoaderListener listener);

    /**
     * 异步加载Bitmap图片
     * @param url 图片地址（url、path、resourceId）
     * @param listener 加载完成回调接口
     */
    void display(String url, ImageLoaderListener listener);

    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param progressId 加载中显示的图片
     * @param uri 图片地址URI
     */
    void displayGifImage(ImageView imageView, String uri , int progressId);
    /**
     * 同步加载bitmap
     * @param context
     * @param url 图片地址（url、path、resourceId）
     */
    Bitmap getBitmapSync(Context context , String url) throws Exception;
    /**
     * 清除硬盘缓存
     * @param context
     */
    void clearImageDiskCache(Context context);
    /**
     * 清除内存缓存
     * @param context
     */
    void clearMemoryCache(Context context);
    /**
     * 清除内存缓存
     * @param context
     */
    void saveImage(Context context , String url , String filePath , String fileName , ImageSaveListener imageSaveListener);

    /**
     * 清除内存缓存
     * @param context
     */
    void trimMemory(Context context , int level);

}
