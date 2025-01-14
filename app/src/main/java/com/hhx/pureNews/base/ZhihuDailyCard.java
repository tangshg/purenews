package com.hhx.pureNews.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.hhx.pureNews.R;
import com.hhx.pureNews.modules.zhihu.mvp.ZhihuDaily;

/**
 * Created by hhx on 2017/6/23.
 */

public class ZhihuDailyCard extends HxBaseCard<ZhihuDaily.StoriesBean> {
    public ZhihuDailyCard(ZhihuDaily.StoriesBean storiesBean) {
        super(storiesBean);
    }


    @Override
    public HxBaseHolder onCreateViewHolder(ViewGroup parent, int viewType, HxBaseRecyclerAdapter.OnItemClickListener listener) {
        return new HxBaseHolder(LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_news_item, parent, false),listener
        );
    }


    @Override
    public void onBindViewHolder(HxBaseHolder holder, int position) {
        TextView title = (TextView) holder.getView(R.id.card_news_item_title_tv);
        title.setText(mData.getTitle());
        ImageView image = (ImageView) holder.getView(R.id.card_news_item_iv);
        String url = mData.getImages().get(0);
        Glide.with(holder.getItemView().getContext()).load(url).into(image);
    }

    @Override
    public int getItemType() {
        return HxBaseRecyclerAdapter.ZHIHU_DAILY_CARD;
    }

    @Override
    public void releaseResource() {

    }
}
