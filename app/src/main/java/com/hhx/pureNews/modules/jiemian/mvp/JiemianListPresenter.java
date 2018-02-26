package com.hhx.pureNews.modules.jiemian.mvp;

import android.util.Log;

import java.util.Iterator;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import com.hhx.pureNews.api.ApiManager;
import com.hhx.pureNews.util.DateUtils;

import static android.media.CamcorderProfile.get;

/**
 * Created by hhx on 2017/8/24.
 */

public class JiemianListPresenter implements JiemianListContract.Presenter {
    private String mTag;
    private JiemianListContract.View mView;
    private int mPage;

    public JiemianListPresenter(JiemianListContract.View view, String tag) {
        mTag = tag;
        mView = view;
    }

    @Override
    public void loadData() {
        Log.d("jiemian", "https://appapi.jiemian.com/v4/5.0.0/10001/cate/" + mTag + "/0/" + mPage + "/13/1310.json");
        ApiManager.getInstence()
                .getJiemianService()
                .getJiemianNews(mTag, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // 过滤广告标签
                .map(new Function<Jiemian, Jiemian>() {
                    @Override
                    public Jiemian apply(@NonNull Jiemian jiemian) throws Exception {
                        Iterator<Jiemian.ResultBean.CarouselBean> carouseIterator = jiemian.getResult().getCarousel().iterator();
                        Iterator<Jiemian.ResultBean.ListBean> listIterator = jiemian.getResult().getList().iterator();
                        Jiemian.ResultBean.CarouselBean carouseBean;
                        Jiemian.ResultBean.ListBean listBean;
                        while (carouseIterator.hasNext()) {
                            carouseBean = carouseIterator.next();
                            if (!"article".contains(carouseBean.getType())) {
                                carouseIterator.remove();
                            }
                        }
                        while (listIterator.hasNext()) {
                            listBean = listIterator.next();
                            if (!"article".contains(listBean.getType())) {
                                listIterator.remove();
                            }
                        }
                        return jiemian;
                    }
                })
                .map(new Function<Jiemian, List<Jiemian.ResultBean.ListBean>>() {
                    @Override
                    public List<Jiemian.ResultBean.ListBean> apply(@NonNull Jiemian jiemian) throws Exception {
//                        Jiemian.ResultBean.CarouselBean carouseBean;
//                        Jiemian.ResultBean.ListBean listBean = new Jiemian.ResultBean.ListBean();
                        List<Jiemian.ResultBean.ListBean> listList = jiemian.getResult().getList();
                        for (int i = 0; i < listList.size(); i++) {

                            String before = DateUtils.timeStamp2RelativeTime(
                                    Long.valueOf(listList.get(i).getArticle().getAr_pt()) * 1000);
                            Log.e("before", before);
                            listList.get(i).getArticle().setAr_pt(before);

                        }
                        return listList;
                    }
                })
                .subscribe(new Observer<List<Jiemian.ResultBean.ListBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mPage++;
                    }

                    @Override
                    public void onNext(@NonNull List<Jiemian.ResultBean.ListBean> listBeen) {
                        mView.loadMoreSuccess(listBeen);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("jiemianLoadMoreError", e.getMessage());
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
        mPage = 1;
        Log.e("jiemianRefresh", "https://appapi.jiemian.com/v4/5.0.0/10001/cate/" + mTag + "/0/" + mPage + "/13/1310.json");
        ApiManager.getInstence()
                .getJiemianService()
                .getJiemianNews(mTag, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // 过滤广告标签
                .map(new Function<Jiemian, Jiemian>() {
                    @Override
                    public Jiemian apply(@NonNull Jiemian jiemian) throws Exception {
                        Iterator<Jiemian.ResultBean.CarouselBean> carouseIterator = jiemian.getResult().getCarousel().iterator();
                        Iterator<Jiemian.ResultBean.ListBean> listIterator = jiemian.getResult().getList().iterator();
                        Jiemian.ResultBean.CarouselBean carouseBean;
                        Jiemian.ResultBean.ListBean listBean;
                        while (carouseIterator.hasNext()) {
                            carouseBean = carouseIterator.next();
                            if (!"article".contains(carouseBean.getType())) {
                                carouseIterator.remove();
                            }
                        }
                        while (listIterator.hasNext()) {
                            listBean = listIterator.next();
                            if (!"article".contains(listBean.getType())) {
                                listIterator.remove();
                            }
                        }
                        return jiemian;
                    }
                })
                .map(new Function<Jiemian, List<Jiemian.ResultBean.ListBean>>() {
                    @Override
                    public List<Jiemian.ResultBean.ListBean> apply(@NonNull Jiemian jiemian) throws Exception {
                        Jiemian.ResultBean.CarouselBean carouseBean;

                        List<Jiemian.ResultBean.ListBean> listList = jiemian.getResult().getList();
                        Iterator<Jiemian.ResultBean.CarouselBean> carouseIterator = jiemian.getResult().getCarousel().iterator();
                        for (int i = 0; i < listList.size(); i++) {

                            String before = DateUtils.timeStamp2RelativeTime(
                                    Long.valueOf(listList.get(i).getArticle().getAr_pt()) * 1000);
                            Log.e("before", before);
                            listList.get(i).getArticle().setAr_pt(before);

                        }
                        while (carouseIterator.hasNext()) {
                            Jiemian.ResultBean.ListBean listBean = new Jiemian.ResultBean.ListBean();
                            Jiemian.ResultBean.ListBean.ArticleBean articleBean = new Jiemian.ResultBean.ListBean.ArticleBean();
                            carouseBean = carouseIterator.next();
                            listBean.setType(carouseBean.getType());
                            articleBean.setAr_id(carouseBean.getArticle().getAr_id());
                            articleBean.setAr_tl(carouseBean.getArticle().getAr_tl());
                            articleBean.setAr_image(carouseBean.getArticle().getAr_image());
                            articleBean.setAr_pt("置顶");
                            listBean.setArticle(articleBean);
                            listList.add(0, listBean);
                        }
                        return listList;
                    }
                })
                .subscribe(new Observer<List<Jiemian.ResultBean.ListBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mPage++;
                    }

                    @Override
                    public void onNext(@NonNull List<Jiemian.ResultBean.ListBean> listBean) {

                        mView.refreshSuccess(listBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("jiemianRefreshError", e.getMessage());
                        mView.refreshFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
