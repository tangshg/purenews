package com.hhx.pureNews.modules.wangyinews.mvp;

import android.util.Log;

import java.util.Iterator;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import com.hhx.pureNews.api.ApiManager;
import com.hhx.pureNews.api.WangyiNewsApi;
import com.hhx.pureNews.util.DateUtils;

import static android.media.CamcorderProfile.get;

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
        if ("T1348647909107".contains(mTag)) {
            wangyiNewsObservable = wangyiNewsApi.getWangyiFire(num);
        } else {
            wangyiNewsObservable = wangyiNewsApi.getWangyiList(mTag, num);
        }
        wangyiNewsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<WangyiNews, WangyiNews>() {
                    @Override
                    public WangyiNews apply(@NonNull WangyiNews wangyiNews) throws Exception {
                        Iterator<WangyiNews.Bean> beanIterator = wangyiNews.getBean().iterator();
                        WangyiNews.Bean bean;
                        while (beanIterator.hasNext()) {
                            bean = beanIterator.next();
                            String mt = bean.getMtime();
                            String before = DateUtils.date2RelativeTime(mt);
                            bean.setMtime(before);
                            if ("超过一年".equals(before)||"live".equals(bean.getSkipType())) {
                               beanIterator.remove();
                            }

                        }
                        return wangyiNews;
                    }
                })
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
        if ("T1348647909107".contains(mTag)) {
            wangyiNewsObservable = wangyiNewsApi.getWangyiFire(num);
        } else {
            wangyiNewsObservable = wangyiNewsApi.getWangyiList(mTag, num);
        }
        wangyiNewsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<WangyiNews, WangyiNews>() {
                    @Override
                    public WangyiNews apply(@NonNull WangyiNews wangyiNews) throws Exception {
                        Iterator<WangyiNews.Bean> beanIterator = wangyiNews.getBean().iterator();
                        WangyiNews.Bean bean;
                        while (beanIterator.hasNext()) {
                            bean = beanIterator.next();
                            String mt = bean.getMtime();
                            String before = DateUtils.date2RelativeTime(mt);
                            bean.setMtime(before);
                            if ("超过一年".equals(before)||"live".equals(bean.getSkipType())) {
                                beanIterator.remove();
                            }

                        }

                        return wangyiNews;
                    }
                })
                .subscribe(new Observer<WangyiNews>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WangyiNews wangyiNews) {
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
