package my.hhx.com.chunnews.modules.wangyinews.mvp;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import my.hhx.com.chunnews.api.ApiManager;
import my.hhx.com.chunnews.api.WangyiNewsApi;

/**
 * Created by hhx on 2017/8/23.
 */

public class WangyiNewsPresenter implements WangyiNewsContract.Presenter {
    //private WangyiNewsFragment wangyiNewsFragment;
    private WangyiNewsContract.View mView;
    private String mTag;
    private int num = 0;

    public WangyiNewsPresenter(WangyiNewsContract.View view, String tag) {
        mView = view;
        mTag = tag;
    }

    @Override
    public void refreshData() {
        num = 0;
        WangyiNewsApi wangyiNewsApi = ApiManager.getInstence()
                .getWangyiNewsService();
        Observable<WangyiNews> wangyiNewsObservable;
        if (mTag.contains("T1348647909107")) {
            wangyiNewsObservable = wangyiNewsApi.getWangyiFire(num);
        } else {
            wangyiNewsObservable = wangyiNewsApi.getWangyiList(mTag, num);
        }
        wangyiNewsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangyiNews>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WangyiNews wangyiNews) {
                        Log.e("WangyiPresenter", wangyiNews.toString());
                        num = num + 20;
                        mView.refreshSuccess(wangyiNews);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.refreshFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void loadData() {
        WangyiNewsApi wangyiNewsApi = ApiManager.getInstence()
                .getWangyiNewsService();
        Observable<WangyiNews> wangyiNewsObservable;
        if (mTag.contains("T1348647909107")) {
            wangyiNewsObservable = wangyiNewsApi.getWangyiFire(num);
        } else {
            wangyiNewsObservable = wangyiNewsApi.getWangyiList(mTag, num);
        }
        wangyiNewsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangyiNews>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WangyiNews wangyiNews) {
                        Log.e("WangyiPresenter", wangyiNews.toString());
                        num = num + 20;
                        mView.loadMoreSuccess(wangyiNews);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.loadMoreFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void loadCache() {

    }


}
