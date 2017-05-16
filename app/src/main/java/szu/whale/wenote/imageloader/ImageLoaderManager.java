package szu.whale.wenote.imageloader;

import android.content.Context;

/**
 * description:
 * author：xujianye
 * date: 2017/1/19 0019 10:57
 * email：jianyexu@hyx.com
 */
public class ImageLoaderManager {

    public static final String TYPE_PICASSO = "type_picasso"; // Picasso加载
    public static final String TYPE_GLIDE = "type_glide"; // Glide加载

    public static String type_default = TYPE_GLIDE;

    private static GlideRequest glideRequest;

    private static Context mContext;
    private static int mProgressId, mErrorId;

    public static ImageLoaderListener getRequest() {
        return getRequest(type_default);
    }

    public static ImageLoaderListener getRequest(String type) {
        switch (type) {
            case TYPE_GLIDE:
                return getGlideRequest();

            case TYPE_PICASSO:
            default:
                return getGlideRequest();
        }
    }

    private static GlideRequest getGlideRequest() {
        if (glideRequest == null) {
            synchronized (ImageLoaderManager.class) {
                if (glideRequest == null) {
                    glideRequest = new GlideRequest(mContext, mProgressId, mErrorId);
                }
            }
        }
        return glideRequest;
    }

    public static void init(Context context) {
        init(context, -1, -1);
    }

    /**
     *
     * @param context applicationContext
     * @param progressId glide加载中显示的图片
     * @param errorId glide加载失败显示的图片
     */
    public static void init(Context context, int progressId, int errorId) {
        mContext = context;
        mProgressId = progressId;
        mErrorId = errorId;
    }
}
