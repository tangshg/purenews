package my.hhx.com.chunnews.api;

import io.reactivex.Observable;
import my.hhx.com.chunnews.modules.wangyinews.mvp.WangyiPhoto;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by hhx on 17-9-4.
 */

public interface WangyiPhotoApi {
    //api/set/0001/2273674.json
    @Headers({
            "User-Agent: NewsApp"
    })
    @GET("api/set/{id1}/{id2}.json")
    Observable<WangyiPhoto> getWangyiPhoto(@Path("id1") String id1, @Path("id2") String id2);
}
