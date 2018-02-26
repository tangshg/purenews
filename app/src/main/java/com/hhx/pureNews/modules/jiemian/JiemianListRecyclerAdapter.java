package com.hhx.pureNews.modules.jiemian;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.hhx.pureNews.GlideApp;
import com.hhx.pureNews.R;
import com.hhx.pureNews.modules.jiemian.mvp.Jiemian;

/**
 * Created by hhx on 2017/8/23.
 */

public class JiemianListRecyclerAdapter extends BaseQuickAdapter<Jiemian.ResultBean.ListBean, BaseViewHolder> {

    public JiemianListRecyclerAdapter(List<Jiemian.ResultBean.ListBean> data) {
        super(R.layout.card_news_item, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Jiemian.ResultBean.ListBean item) {
        helper.setText(R.id.card_news_item_title_tv, item.getArticle().getAr_tl());
        GlideApp.with(mContext).load(item.getArticle().getAr_image()).centerCrop().into((ImageView) helper.getView(R.id.card_news_item_iv));
        helper.setText(R.id.card_news_item_time_tv, item.getArticle().getAr_pt());
    }
}
