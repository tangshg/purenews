//package my.hhx.com.chunnews.modules.jiemian.mvp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.scwang.smartrefresh.layout.SmartRefreshLayout;
//import com.scwang.smartrefresh.layout.api.RefreshLayout;
//import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.Unbinder;
//import my.hhx.com.chunnews.R;
//import my.hhx.com.chunnews.modules.ithome.mvp.ItArticleActivity;
//import my.hhx.com.chunnews.modules.jiemian.JiemianListRecyclerAdapter;
//
///**
// * Created by hhx on 2017/8/23.
// */
//
//public class JiemianListFragment extends Fragment implements JiemianListContract.View, OnRefreshListener {
//    @BindView(R.id.jiemian_list_recycler)
//    RecyclerView itListRecycler;
//    JiemianListRecyclerAdapter mAdapter;
//    @BindView(R.id.jiemian_list_refresh)
//    SmartRefreshLayout jiemianListRefresh;
//    private List<Jiemian> mList = new ArrayList<>();
//    Unbinder unbinder;
//    private static String mTag;
//    private boolean isrefresh = false;
//    private JiemianListPresenter JiemianListPresenter = new JiemianListPresenter(this, mTag);
//    private View view;
//
//    public static JiemianListFragment newInstance(String tag) {
//        mTag = tag;
//        return new JiemianListFragment();
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        if (view == null) {
//            view = inflater.inflate(R.layout.fragment_jiemian_list, container, false);
//            unbinder = ButterKnife.bind(this, view);
//            initView();
//            isrefresh = true;
//        } else {
//            isrefresh = false;
//        }
//        jiemianListRefresh.setOnRefreshListener(this);
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        if (isrefresh) {
//            onRefresh(jiemianListRefresh);
//        }
//
//    }
//
//    @Override
//    public void initView() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        itListRecycler.setLayoutManager(linearLayoutManager);
//        jiemianListRefresh.setOnRefreshListener(this);
//
//        mAdapter = new JiemianListRecyclerAdapter(mList);
//        itListRecycler.setAdapter(mAdapter);
//        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                JiemianListPresenter.loadData();
//
//            }
//        }, itListRecycler);
//        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
////                Intent intent = new Intent(getContext(), ItArticleActivity.class);
////                intent.putExtra("newsId", mList.get(position).getNewsid());
////                intent.putExtra("title", mList.get(position).getTitle());
////                intent.putExtra("img", mList.get(position).getImage());
////                intent.putExtra("share", mList.get(position).getUrl());
////                startActivity(intent);
//            }
//        });
//
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//
//
//    }
//
//
//    @Override
//    public void refreshFail() {
//        jiemianListRefresh.finishRefresh(false);
//        Toast.makeText(getContext(), "加载错误", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void refreshData() {
//        JiemianListPresenter.refreshData();
//    }
//
//    @Override
//    public void refreshSuccess(List<Jiemian> itItems) {
//        if (itItems == null) {
//            return;
//        }
//        if (mList != null) {
//            mList.clear();
//            mList.addAll(itItems);
//        }
//
//        if (mAdapter != null && mList != null) {
//            mAdapter.setNewData(mList);
//        }
//        jiemianListRefresh.finishRefresh(true);
//
//    }
//
//    @Override
//    public void loadMoreSuccess(List<Jiemian> itItems) {
//        if (itItems == null) {
//            mAdapter.loadMoreEnd();
//            return;
//        }
//        mAdapter.addData(itItems);
//        mAdapter.loadMoreComplete();
//    }
//
//    @Override
//    public void loadMoreFail() {
//        mAdapter.loadMoreFail();
//    }
//
//
//    @Override
//    public void onRefresh(RefreshLayout refreshlayout) {
//        refreshData();
//    }
//}
