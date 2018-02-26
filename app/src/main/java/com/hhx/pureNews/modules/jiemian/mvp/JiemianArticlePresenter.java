package com.hhx.pureNews.modules.jiemian.mvp;

import android.util.Log;

import java.net.URLDecoder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import com.hhx.pureNews.api.ApiManager;
import com.hhx.pureNews.modules.ithome.mvp.ItArticleContract;

/**
 * Created by hhx on 2017/8/27.
 */

public class JiemianArticlePresenter implements ItArticleContract.Presenter {
    private JiemianArticleContract.View mView;

    public JiemianArticlePresenter(JiemianArticleContract.View view) {
        mView = view;
    }

    @Override
    public void loadArticle(String newsId) {
        ApiManager.getInstence()
                .getJiemianService()
                .getJiemianArticle(newsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //转换url字符编码为中文
                .map(new Function<JiemianArticle, JiemianArticle.ResultBean>() {
                    @Override
                    public JiemianArticle.ResultBean apply(@NonNull JiemianArticle jiemianArticle) throws Exception {
                        jiemianArticle.getResult().getArticle()
                                .setAr_con(URLDecoder.decode(jiemianArticle.getResult().getArticle().getAr_con(), "utf-8"));
                        return jiemianArticle.getResult();
                    }
                })
                .subscribe(new Observer<JiemianArticle.ResultBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull JiemianArticle.ResultBean resultBean) {
                        mView.loadSucess(resultBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("jiemianArticleLoadError", "error");
                        mView.loadFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
