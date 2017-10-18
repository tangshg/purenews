package my.hhx.com.chunnews.modules.wangyinews.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import my.hhx.com.chunnews.R;
import my.hhx.com.chunnews.modules.wangyinews.WangyiNewsRecyclerAdapter;

/**
 * Created by hhx on 2017/5/23.
 */

public class WangyiNewsFragment extends Fragment implements WangyiNewsContract.View, OnRefreshListener {
    @BindView(R.id.wangyi_recycler)
    RecyclerView wangyiRecycler;
    @BindView(R.id.wangyi_refresh)
    SmartRefreshLayout wangyiRefresh;
    private WangyiNewsRecyclerAdapter mAdapter;
    private List<WangyiNews.Bean> mList = new ArrayList<>();
    Unbinder unbinder;
    private WangyiNewsContract.Presenter mPreenter = new WangyiNewsPresenter(this, sTag);
    private static String sTag;
    private boolean isRefresh;
    private View view;


    public static WangyiNewsFragment newInstance(String tag) {
        sTag = tag;
        return new WangyiNewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_wangyi_news, container, false);
            unbinder = ButterKnife.bind(this, view);
            initView();
            isRefresh = true;
        } else {
            isRefresh = false;
        }

        wangyiRefresh.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isRefresh) {
            onRefresh(wangyiRefresh);
        }
    }

    @Override
    public void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        wangyiRecycler.setLayoutManager(linearLayoutManager);
        wangyiRecycler.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        wangyiRefresh.setOnRefreshListener(this);

        mAdapter = new WangyiNewsRecyclerAdapter(mList);

        wangyiRecycler.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPreenter.loadData();
            }
        }, wangyiRecycler);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (mList.get(position).getSkipType() != null && mList.get(position).getSkipType().contains("photoset")) {
                    Intent intent = new Intent(getContext(), WangyiPhotoActivity.class);
                    intent.putExtra("id", mList.get(position).getSkipID());
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(getContext(), WangyiArticleActivity.class);
                    intent.putExtra("id", mList.get(position).getPostid());
                    intent.putExtra("image", mList.get(position).getImgsrc());
                    intent.putExtra("title", mList.get(position).getTitle());
                    intent.putExtra("share", mList.get(position).getUrl_3w());
//                            CacheUtils cacheUtils = CacheUtils.getInstance();
//                            cacheUtils.put(mList.get(position).getPostid(), mList.get(position).getPostid());

                    startActivity(intent);
                }


            }
        });


    }

    @Override
    public void refreshFail() {
        wangyiRefresh.finishRefresh(false);
        if (getContext() == null) {
            Log.e("refreshFail","it");
            return;
        }
        Toast.makeText(getContext(), "加载错误", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void refreshData() {
        mPreenter.refreshData();
    }

    @Override
    public void refreshSuccess(WangyiNews wangyiNews) {
        if (wangyiNews.getBean() == null) {
            return;
        }

        if (mList != null) {
            mList.clear();
        }

        for (int i = 0; i < wangyiNews.getBean().size(); i++) {
            WangyiNews.Bean bean = wangyiNews.getBean().get(i);
            if (i == 0) {
                bean.setMultiItem(WangyiNews.Bean.BANNER);
                mList.add(bean);
            } else {
                if (bean.getSpecialextra() == null) {
                    bean.setMultiItem(WangyiNews.Bean.ITEM);
                    mList.add(bean);
                }

            }

        }
        mAdapter.setNewData(mList);
        wangyiRefresh.finishRefresh(true);

    }

    @Override
    public void loadMoreSuccess(WangyiNews wangyiNews) {
        if (wangyiNews == null) {
            mAdapter.loadMoreEnd();
            return;
        }
        List<WangyiNews.Bean> list = new ArrayList<>();
        for (int i = 0; i < wangyiNews.getBean().size(); i++) {
            WangyiNews.Bean bean = wangyiNews.getBean().get(i);
            if (i != 0) {
                bean.setMultiItem(WangyiNews.Bean.ITEM);
                list.add(bean);
            }

        }
        mAdapter.addData(list);
        mAdapter.loadMoreComplete();
    }

    @Override
    public void loadMoreFail() {

        mAdapter.loadMoreFail();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        Log.e("onrefresh", "wangyi");
        refreshData();
    }
}
