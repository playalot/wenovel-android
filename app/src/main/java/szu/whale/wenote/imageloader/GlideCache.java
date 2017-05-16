package szu.whale.wenote.imageloader;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * description: 自定义GlideMode需在AndroidManifest.xml文件中配置，否则将不生效, 配置如下
 * <meta-data android:name="com.hyx.baselibrary.Utils.ImageLoader.GlideCache"
              android:value="GlideModule"/>
 * author：xujianye
 * date: 2017/2/16 0016 09:59
 * email：jianyexu@hyx.com
 */
public class GlideCache implements GlideModule {

    private static final String CACHE_PATH = "/maizuo/GlideCache";
    private static final int CACHE_SIZE = 50; // 50M

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        //设置图片的显示格式ARGB_8888(指图片大小为32bit)
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //设置磁盘缓存目录（和创建的缓存目录相同）
        File storageDirectory = Environment.getExternalStorageDirectory();
        String downloadDirectoryPath = storageDirectory + CACHE_PATH;
        //设置缓存的大小(单位M转换为byte)
        int cacheSize = CACHE_SIZE * 1024 * 1024;
        builder.setDiskCache(new DiskLruCacheFactory(downloadDirectoryPath, cacheSize));

        // 获取默认缓存大小
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        // 缓存大小为默认大小的1.2倍
        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        // 设置缓存大小
        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));

    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }

}
