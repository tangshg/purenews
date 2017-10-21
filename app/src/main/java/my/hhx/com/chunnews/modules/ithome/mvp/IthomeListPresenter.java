package my.hhx.com.chunnews.modules.ithome.mvp;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import my.hhx.com.chunnews.api.ApiManager;
import my.hhx.com.chunnews.util.DateUtils;
import my.hhx.com.chunnews.util.ITHomeUtils;

/**
 * Created by hhx on 2017/8/24.
 */

public class IthomeListPresenter implements IthomeListContract.Presenter {
    private String mTag;
    private IthomeListContract.View mView;
    private String mLastId;
    private ArrayList<ItItem> mList = new ArrayList<>();

    public IthomeListPresenter(IthomeListContract.View view, String tag) {
        mTag = tag;
        mView = view;
    }

    @Override
    public void loadData() {
        ApiManager.getInstence()
                .getmItHomeService()
                .getITHomeMore(mTag, ITHomeUtils.getMinNewsId(mLastId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ITResponse, ITResponse>() {
                    @Override
                    public ITResponse apply(@NonNull ITResponse itResponse) throws Exception {
                        Iterator<ItItem> itItemIterator = itResponse.getChannel().getItItems().iterator();
                        while (itItemIterator.hasNext()) {
                            ItItem itItem = itItemIterator.next();
                            String pt = itItem.getPostdate();
                            itItem.setPostdate(DateUtils.date2RelativeTime(pt));
                            if (itItem.getUrl().contains("digi") || itItem.getTitle().contains("辣品")) {
                                itItemIterator.remove();
                            }
                        }

                        return itResponse;
                    }
                })
                .subscribe(new Observer<ITResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ITResponse itResponse) {
                        if (mList != null) {
                            mList.clear();
                        }
                        mList = itResponse.getChannel().getItItems();
                        mLastId = mList.get(mList.size() - 1).getNewsid();
                        mView.loadMoreSuccess(mList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("ItHomeListLoadError", e.getMessage());
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

    @Override
    public void refreshData() {
        ApiManager.getInstence()
                .getmItHomeService()
                .getITHomeNewest(mTag)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ITResponse, ITResponse>() {
                    @Override
                    public ITResponse apply(@NonNull ITResponse itResponse) throws Exception {
                        Iterator<ItItem> itItemIterator = itResponse.getChannel().getItItems().iterator();
                        while (itItemIterator.hasNext()) {
                            ItItem itItem = itItemIterator.next();
                            String pt = itItem.getPostdate();
                            itItem.setPostdate(DateUtils.date2RelativeTime(pt));
                            if (itItem.getUrl().contains("digi") || itItem.getTitle().contains("辣品")) {
                                itItemIterator.remove();
                            }

                        }

                        return itResponse;
                    }
                })
                .subscribe(new Observer<ITResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ITResponse itResponse) {
                        mList = itResponse.getChannel().getItItems();
                        mLastId = mList.get(mList.size() - 1).getNewsid();
                        Log.e("itPressent", mLastId);
                        Log.e("itPressent", mList.get(0).toString());
                        mView.refreshSuccess(mList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("ItHomeListRefreshError", e.getMessage());
                        mView.refreshFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
