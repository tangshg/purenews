package com.hhx.pureNews.modules.wangyinews.mvp;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import com.hhx.pureNews.api.ApiManager;

/**
 * Created by hhx on 17-9-5.
 */

public class WangyiPhotoPresenter implements WangyiPhotoContract.Presenter {

    private WangyiPhotoContract.View mView;

    public WangyiPhotoPresenter(WangyiPhotoContract.View view) {
        mView = view;
    }

    @Override
    public void loadPhotoSet(final String id1, final String id2) {
        ApiManager.getInstence()
                .getWangyiPhotoService()
                .getWangyiPhoto(id1, id2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangyiPhoto>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WangyiPhoto wangyiPhoto) {
                        Log.e("ha", wangyiPhoto.toString());
                        mView.loadSucess(wangyiPhoto);
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
