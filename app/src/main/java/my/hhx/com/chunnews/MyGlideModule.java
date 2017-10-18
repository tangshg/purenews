package my.hhx.com.chunnews;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by hhx on 17-9-10.
 */
@GlideModule
public class MyGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //设置磁盘缓存大小最大100M
        int size = 100 * 1024 * 1024;
        //设置磁盘缓存
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, size));
    }



    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {

    }
}
