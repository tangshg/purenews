package com.hhx.pureNews.modules.zhihu;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.hhx.pureNews.R;
import com.hhx.pureNews.modules.zhihu.mvp.ZhihuDaily;

/**
 * Created by hhx on 2017/6/18.
 */

public class ZhiHuDailyRecyclerAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<ZhihuDaily> mList;

    public ZhiHuDailyRecyclerAdapter(Context context, ArrayList<ZhihuDaily> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(mContext)
                        .inflate(R.layout.card_news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder myHolder= (ViewHolder) holder;

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.card_news_item_iv)
        ImageView zhihuDailyItemIv;
        @BindView(R.id.card_news_item_title_tv)
        TextView zhihuDailyItemTitleTv;
        @BindView(R.id.card_news_item_time_tv)
        TextView zhihuDailyItemTimeTv;
        @BindView(R.id.card_news_item)
        CardView zhihuDailyItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
