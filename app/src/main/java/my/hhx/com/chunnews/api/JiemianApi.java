//package my.hhx.com.chunnews.api;
//
//
//import io.reactivex.Observable;
//import my.hhx.com.chunnews.modules.jiemian.mvp.Jiemian;
//import retrofit2.http.GET;
//import retrofit2.http.Path;
//
///**
// * Created by Glooory on 2016/10/12 0012 12:42.
// */
//
//public interface JiemianApi {
//
//    //请求界面新闻最新的数据
//    //https://appapi.jiemian.com/v4/5.0.0/10001/cate/123/0/1/13/1310.json
//    @GET("{tag}/0/{page}/13/1310.json")
//    Observable<Jiemian> getJiemianNews(@Path("tag") String tag, @Path("page") String page);
//
//
//
//
//}
