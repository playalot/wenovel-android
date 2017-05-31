package szu.whale.wenote.imageloader;

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


    private static BaseImageLoaderStrategy getBaseImageLoaderStrategy() {
        if (baseImageLoaderStrategy == null) {
            synchronized (ImageLoader.class) {
                if (baseImageLoaderStrategy == null) {
                    baseImageLoaderStrategy = new GlideImageLoaderStrategy(mProgressId, mErrorId);
                }
            }
        }
        return baseImageLoaderStrategy;
    }


}
