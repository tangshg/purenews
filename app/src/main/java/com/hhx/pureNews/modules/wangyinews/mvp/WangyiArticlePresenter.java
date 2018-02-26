package com.hhx.pureNews.modules.wangyinews.mvp;

import android.util.Log;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import com.hhx.pureNews.api.ApiManager;

/**
 * Created by hhx on 17-9-5.
 */

public class WangyiArticlePresenter implements WangyiArticleContract.Presenter {

    private WangyiArticleContract.View mView;

    public WangyiArticlePresenter(WangyiArticleContract.View view) {
        mView = view;
    }

    @Override
    public void loadArticle(final String id) {
        ApiManager.getInstence()
                .getWangyiNewsService()
                .getWangyiContent(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Map<String, WangyiContent.Content>, WangyiContent>() {
                    @Override
                    public WangyiContent apply(@NonNull Map<String, WangyiContent.Content> stringWangyiContentMap) throws Exception {
                        WangyiContent wangyicontent = new WangyiContent();
                        wangyicontent.setContent(stringWangyiContentMap.get(id));
                        return wangyicontent;
                    }

                })
                .subscribe(new Observer<WangyiContent>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WangyiContent wangyiContent) {
                        Log.e("ha", wangyiContent.toString());
                        mView.loadSucess(wangyiContent);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("ha", "222");
                        mView.loadFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
