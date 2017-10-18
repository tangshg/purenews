package my.hhx.com.chunnews.api;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import my.hhx.com.chunnews.IApplication;
import my.hhx.com.chunnews.config.Config;
import my.hhx.com.chunnews.util.NetWorkUtils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by hhx on 2017/5/23.
 */

public class ApiManager {
    private ZhihuDailyApi mZhihuDailyApi;
    private ITHomeApi mItHomeApi;
    private WangyiNewsApi mWangyiNewsApi;
    private WangyiPhotoApi mWangyiPhotoApi;
    //private JiemianApi mJiemianApi;
    private static ApiManager sApiManager;
    private static final int TIMEOUT_DISCONNECT = 60 * 60 * 24 * 7; //7天

    private static  Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            if(!NetWorkUtils.isNetworkConnected(IApplication.sContext)){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.e("retrofit","no network");
            }
            Response originalResponse = chain.proceed(request);
            if(NetWorkUtils.isNetworkConnected(IApplication.sContext)){
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                Log.e("retrofit","network");
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", cacheControl)
                        .build();
            }else{
                Log.e("retrofit","no network2");
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=604800")//7天
                        .build();
            }



        }
    };



    private ApiManager() {

    }

    public OkHttpClient getOkhttpClient() {
        OkHttpClient httpClient;
        File httpCacheDirectory = new File(IApplication.sContext.getCacheDir() + "/httpCache");
        int cacheSize = 50 * 1024 * 1024;//设置缓存文件大小为50M
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置连接超时
                .readTimeout(10, TimeUnit.SECONDS)//读取超时
                .writeTimeout(10, TimeUnit.SECONDS)//写入超时
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)//添加自定义缓存拦截器
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache)//把缓存添加进来
                .build();
        return httpClient;
    }

    /**
     * 单例模式
     */
    public static ApiManager getInstence() {
        if (sApiManager == null) {
            synchronized (ApiManager.class) {
                if (sApiManager == null) {
                    sApiManager = new ApiManager();
                }
            }
        }
        return sApiManager;
    }

    /**
     * 封装知乎日报Api
     */
    public ZhihuDailyApi getmZhihuDailyService() {
        if (mZhihuDailyApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.ZHIHU_DAILY_API_URL)
                    .client(getOkhttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mZhihuDailyApi = retrofit.create(ZhihuDailyApi.class);
        }
        return mZhihuDailyApi;
    }

    /**
     * 封装It之家Api
     */
    public ITHomeApi getmItHomeService() {
        if (mItHomeApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.ITHOME_API_URL)
                    .client(getOkhttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
            mItHomeApi = retrofit.create(ITHomeApi.class);
        }
        return mItHomeApi;
    }

    public WangyiNewsApi getWangyiNewsService() {
        if (mWangyiNewsApi == null) {
            mWangyiNewsApi = new Retrofit.Builder()
                    .baseUrl(Config.WANGYI_API_URL)
                    .client(getOkhttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WangyiNewsApi.class);
        }
        return mWangyiNewsApi;
    }

    public WangyiPhotoApi getWangyiPhotoService() {
        if (mWangyiPhotoApi == null) {
            mWangyiPhotoApi = new Retrofit.Builder()
                    .baseUrl(Config.WANGYI_PHOTO_URL)
                    .client(getOkhttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WangyiPhotoApi.class);
        }
        return mWangyiPhotoApi;
    }
//    public JiemianApi getJiemianService() {
//        if (mJiemianApi == null) {
//            mJiemianApi = new Retrofit.Builder()
//                    .baseUrl(Config.JIEMIAN_API_URL)
//                    .client(getOkhttpClient())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(JiemianApi.class);
//        }
//        return mJiemianApi;
//    }

}
