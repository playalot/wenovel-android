package szu.whale.wenote.imageloader;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * description:
 * author：xujianye
 * date: 2017/1/19 0019 10:55
 * email：jianyexu@hyx.com
 */
public interface ImageLoaderListener {

    /**
     * 加载图片并显示
     * @param imageView 显示的view
     * @param url 图片地址（url、path、resourceId）
     * @param progressId 加载中显示的图片
     * @param errorId 加载失败显示的图片
     */
    void display(ImageView imageView, String url, int progressId, int errorId);

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
     * @param url 图片地址
     */
    void display(ImageView imageView, String url);

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
    void display(ImageView imageView, String url, ImageListener listener);

    /**
     * 异步加载Bitmap图片
     * @param url 图片地址（url、path、resourceId）
     * @param listener 加载完成回调接口
     */
    void display(String url, ImageListener listener);

    /**
     * 同步加载bitmap
     * @param url 图片地址（url、path、resourceId）
     */
    Bitmap getBitmapSync(String url) throws Exception;

}
