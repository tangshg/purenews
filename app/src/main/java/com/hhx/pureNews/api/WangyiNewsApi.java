package com.hhx.pureNews.api;

import java.util.Map;

import io.reactivex.Observable;
import com.hhx.pureNews.modules.wangyinews.mvp.WangyiContent;
import com.hhx.pureNews.modules.wangyinews.mvp.WangyiNews;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by hhx on 2017/8/23.
 */

public interface WangyiNewsApi {
    //http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
    @Headers({
            "User-Agent: NewsApp"
    })
    @GET("headline/T1348647909107/{num}-20.html")
    Observable<WangyiNews> getWangyiFire(@Path("num") int num);

    @Headers({
            "User-Agent: NewsApp"
    })
    @GET("list/{type}/{num}-20.html")
    Observable<WangyiNews> getWangyiList(@Path("type") String type, @Path("num") int num);

    //http://c.m.163.com/nc/article/CTE922JG000189FH/full.html
    @Headers({
            "User-Agent: NewsApp"
    })
    @GET("{id}/full.html")
    Observable<Map<String, WangyiContent.Content>> getWangyiContent(@Path("id") String id);
}
