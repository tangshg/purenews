package com.hhx.pureNews.modules.zhihu.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hhx.pureNews.R;
import com.hhx.pureNews.base.Card;
import com.hhx.pureNews.base.HxBaseRecyclerAdapter;
import com.hhx.pureNews.base.ZhihuDailyCard;
import com.hhx.pureNews.base.ZhihuTopCard;

/**
 * Created by hhx on 2017/5/23.
 */

public class ZhiHuDailyFragment extends Fragment implements OnRefreshListener, ZhiHuDailyContract.View {
    @BindView(R.id.zhihu_daily_swipe)
    SmartRefreshLayout zhihuDailySwipe;
    @BindView(R.id.no_see_tv)
    TextView noSeeTv;
    @BindView(R.id.zhihu_daily_recycler)
    RecyclerView zhihuDailyRecycler;
    private ZhihuDailyPresenter zhihuDailyPresenter = new ZhihuDailyPresenter(this);
    private ArrayList<ZhihuDaily.StoriesBean> mList;
    private ArrayList<ZhihuDaily.TopStoriesBean> mTopList;
    private HxBaseRecyclerAdapter mAdapter;
    private boolean isFresh = false;
    private boolean isLoading = false;
    private LinearLayoutManager linearLayoutManager;
    private boolean isRefresh;
    Unbinder unbinder;
    private View view;

    public static ZhiHuDailyFragment newInstance() {
        return new ZhiHuDailyFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.fragment_zhihu_daily, container, false);
            isRefresh = true;
            unbinder = ButterKnife.bind(this, view);
            initView();
        } else {
            isRefresh = false;

        }
        zhihuDailySwipe.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) getActivity().findViewById(R.id.toolbar));
        onRefresh(zhihuDailySwipe);
    }

    public void initView() {
        mList = new ArrayList<>();
        mTopList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getContext());
        zhihuDailyRecycler.setLayoutManager(linearLayoutManager);
        if (isRefresh) {
            zhihuDailyRecycler.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        }

        zhihuDailySwipe.setOnRefreshListener(this);
        mAdapter = new HxBaseRecyclerAdapter();
        zhihuDailyRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (linearLayoutManager.findLastVisibleItemPosition() == mAdapter.getItemCount() - 1 && !isLoading && dy > 0) {
                    isLoading = true;
                    zhihuDailyPresenter.loadData();

                }

            }
        });
        zhihuDailyRecycler.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new HxBaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(), ZhihuArticleActivity.class);
                intent.putExtra("id", mList.get(position - 1).getId());
                intent.putExtra("title", mList.get(position - 1).getTitle());
                //intent.putExtra("share",mList.get(position-1).)
                startActivity(intent);
            }
        });
    }


    @Override
    public void refreshFail() {
        if (getContext() == null) {
            Log.e("refreshFail","it");
            return;
        }
        //没数据时才会显示无数据，有数据不变
        if (mList.isEmpty()) {
            noSeeTv.setVisibility(View.VISIBLE);
            zhihuDailySwipe.finishRefresh(false);
            Toast.makeText(getContext(), "无法加载数据", Toast.LENGTH_SHORT).show();
        } else {
            zhihuDailySwipe.finishRefresh(false);
            Toast.makeText(getContext(), "无法加载数据，请检查网络后重试", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void refreshData() {
        isFresh = true;
        zhihuDailyPresenter.refreshData();
    }

    @Override
    public void refreshSuccess(final ZhihuDaily zhihuDaily) {
        if (zhihuDaily == null) {
            noSeeTv.setVisibility(View.VISIBLE);
            zhihuDailySwipe.requestFocus();
            return;
        } else {
            noSeeTv.setVisibility(View.GONE);
        }
        if (mList != null) {
            mList.clear();
        }
        if (mTopList != null) {
            mTopList.clear();
        }
        mAdapter.clear();
        if (zhihuDaily.getStories() != null) {
            mList.addAll(zhihuDaily.getStories());
        }
        if (zhihuDaily.getTop_stories() != null) {
            mTopList.addAll(zhihuDaily.getTop_stories());
        }

        mAdapter.setData(getCard(zhihuDaily.getStories()));
        mAdapter.notifyDataSetChanged();

        zhihuDailySwipe.finishRefresh(true);
        isFresh = false;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void loadMoreSuccess(List<ZhihuDaily.StoriesBean> storiesBeen) {
        mList.addAll(storiesBeen);
        mAdapter.addAll(getCard(storiesBeen));
        isLoading = false;
        isFresh = false;
    }

    @Override
    public void loadMoreFail() {
        Toast.makeText(getActivity(), "无法加载数据，请检查网络设置", Toast.LENGTH_SHORT).show();
    }

    public List<Card> getCard(List<ZhihuDaily.StoriesBean> storiesBean) {
        List<Card> cards = new ArrayList<>();
        Log.e("zhihu", zhihuDailySwipe.getState().toString());
        if (isFresh) {
            cards.add(new ZhihuTopCard(getContext(), mTopList));
        }


        for (int i = 0; i < storiesBean.size(); i++) {
            cards.add(new ZhihuDailyCard(storiesBean.get(i)));
        }
        return cards;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        refreshData();
    }
}
