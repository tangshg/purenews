package my.hhx.com.chunnews.modules.ithome.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.CacheUtils;
import com.flyco.tablayout.SlidingTabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import my.hhx.com.chunnews.MessageEvent;
import my.hhx.com.chunnews.R;
import my.hhx.com.chunnews.modules.channel.ChannelActivity;
import my.hhx.com.chunnews.modules.channel.ChannelEntity;

/**
 * Created by hhx on 2017/5/23.
 */

public class IthomeFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.it_tab_layout)
    SlidingTabLayout itTabLayout;
    @BindView(R.id.it_view_pager)
    ViewPager itViewPager;
    private ArrayList<Fragment> mFragment = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    private FragmentStatePagerAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_ithome, container, false);
        unbinder = ButterKnife.bind(this, view);
        toolbar.setTitle("纯新闻");
        getChannel();
        initView();
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshFragment(MessageEvent messageEvent) {
        if (messageEvent.getMessage().equals("refreshFragment")) {
            getChannel();
            if (mAdapter != null) {
                mAdapter = null;
                mAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {
                        return mFragment.get(position);
                    }

                    @Override
                    public int getCount() {
                        return mFragment == null ? 0 : mFragment.size();
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return mTitle.get(position);
                    }

                    public void destroyItem(ViewGroup container, int position, Object object){

                    }

                };
            }
            itViewPager.setAdapter(mAdapter);
            itTabLayout.setViewPager(itViewPager);

        }

    }

    private void getChannel() {
        CacheUtils cacheUtil = CacheUtils.getInstance("channel");
        ArrayList<ChannelEntity> myChannel ;

        myChannel = (ArrayList<ChannelEntity>) cacheUtil.getSerializable("myChannel");
        //用户保存了标签就从缓存里拿标签，否则用初始的

        if (myChannel != null) {
            if (mTitle != null && mFragment != null) {
                mTitle.clear();
                mFragment.clear();
            }
            for (int i = 0; i < myChannel.size(); i++) {
                mTitle.add(myChannel.get(i).getName());
                mFragment.add(IthomeListFragment.newInstance(myChannel.get(i).getTag()));
            }
        } else {
            if (mTitle != null && mFragment != null) {
                mTitle.clear();
                mFragment.clear();
            }
            if(mTitle!=null){
                mTitle.add("最新");
                mTitle.add("评测室");
                mTitle.add("安卓");
                mTitle.add("手机");
                mTitle.add("数码");
            }

            mFragment.add(IthomeListFragment.newInstance("news"));
            mFragment.add(IthomeListFragment.newInstance("labs"));
            mFragment.add(IthomeListFragment.newInstance("android"));
            mFragment.add(IthomeListFragment.newInstance("phone"));
            mFragment.add(IthomeListFragment.newInstance("digi"));
        }

    }

    private void initView() {
        setHasOptionsMenu(true);
        toolbar.setNavigationIcon(R.drawable.ic_menu_menu);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

//        itTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);    //滑动模式


        //添加选项卡
//        for (int i = 0; i < mTitle.size(); i++) {
//            itTabLayout.addNewTab(itTabLayout.newTab().setText(mTitle.get(i)));
//            itTabLayout.add
//        }
        mAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment == null ? 0 : mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }

        };
        itViewPager.setAdapter(mAdapter);
        itViewPager.setOffscreenPageLimit(3);
        itTabLayout.setViewPager(itViewPager);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_tab, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                Intent intent = new Intent(getContext(), ChannelActivity.class);
                intent.putExtra("type", "it");
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }
}
