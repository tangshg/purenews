package com.hhx.pureNews.base;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import com.hhx.pureNews.R;
import com.hhx.pureNews.modules.zhihu.mvp.ZhihuArticleActivity;
import com.hhx.pureNews.modules.zhihu.mvp.ZhihuDaily;
import com.hhx.pureNews.util.GlideImageLoader;

/**
 * Created by hhx on 2017/7/30.
 */

public class ZhihuTopCard extends HxBaseCard<List<ZhihuDaily.TopStoriesBean>> {
    private ArrayList<String> mTitleList;
    private ArrayList<String> mImageList;
    private ArrayList<Integer> mIdList;
    private Context mContext;

    public ZhihuTopCard(Context context, List<ZhihuDaily.TopStoriesBean> topStoriesBean) {
        super(topStoriesBean);
        mImageList = new ArrayList<>();
        mTitleList = new ArrayList<>();
        mIdList = new ArrayList<>();
        mContext = context;
        for (int i = 0; i < topStoriesBean.size(); i++) {
            mImageList.add(topStoriesBean.get(i).getImage());
            mTitleList.add(topStoriesBean.get(i).getTitle());
            mIdList.add(topStoriesBean.get(i).getId());

        }

    }

    @Override
    public HxBaseHolder onCreateViewHolder(ViewGroup parent, int viewType, HxBaseRecyclerAdapter.OnItemClickListener listener) {
        return new HxBaseHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.banner_item, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(HxBaseHolder holder, int position) {
        final Banner banner = (Banner) holder.getView(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(mImageList);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(mTitleList);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                Intent intent = new Intent(mContext, ZhihuArticleActivity.class);
                intent.putExtra("id", mIdList.get(position));
                intent.putExtra("title", mTitleList.get(position));
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemType() {
        return HxBaseRecyclerAdapter.ZHIHU_TOP_CARD;
    }

    @Override
    public void releaseResource() {

    }
}
