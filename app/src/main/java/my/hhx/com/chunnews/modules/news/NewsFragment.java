package my.hhx.com.chunnews.modules.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.CacheUtils;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import my.hhx.com.chunnews.MessageEvent;
import my.hhx.com.chunnews.R;
import my.hhx.com.chunnews.modules.channel.ChannelActivity;
import my.hhx.com.chunnews.modules.channel.ChannelEntity;
import my.hhx.com.chunnews.modules.wangyinews.mvp.WangyiNewsFragment;
import my.hhx.com.chunnews.modules.zhihu.mvp.ZhiHuDailyFragment;

/**
 * Created by hhx on 2017/8/16.
 */

public class NewsFragment extends Fragment {
    @BindView(R.id.materialViewPager)
    MaterialViewPager materialViewPager;
    private List<String> mTitle = new ArrayList<>();
    private List<Fragment> mFragment = new ArrayList<>();
    private FragmentStatePagerAdapter mAdapter;
    private View view;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        Toolbar toolbar = materialViewPager.getToolbar();
        EventBus.getDefault().register(this);
        toolbar.setTitle("纯新闻");
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_white_color_code));
        materialViewPager.getPagerTitleStrip().setIndicatorColorResource(R.color.md_white_color_code);
        materialViewPager.getPagerTitleStrip().setTextColorResource(R.color.md_white_color_code);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        getChannel();
        initView(view);

        return view;

    }


    private void initView(View view) {
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
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                //方法体中什么也不用写
//            }
        };

        materialViewPager.getViewPager().setAdapter(mAdapter);

        materialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page % 4) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "https://maxcdn.icons8.com/app/uploads/2016/03/material-1-1000x563.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }

        });
        //materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount() - 1);
        materialViewPager.getViewPager().setOffscreenPageLimit(3);
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_tab, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshNews(MessageEvent messageEvent) {
        if (messageEvent.getMessage().equals("refreshNews")) {
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

                };
            }

            materialViewPager.getViewPager().setAdapter(mAdapter);
            materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());

        }

    }

    private void getChannel() {
        CacheUtils cacheUtil = CacheUtils.getInstance("channel");
        ArrayList<ChannelEntity> myChannel;

        myChannel = (ArrayList<ChannelEntity>) cacheUtil.getSerializable("myNewsChannel");
        //用户保存了标签就从缓存里拿标签，否则用初始的

        if (myChannel != null) {
            if (mTitle != null && mFragment != null) {
                mTitle.clear();
                mFragment.clear();
            }
            for (int i = 0; i < myChannel.size(); i++) {
                mTitle.add(myChannel.get(i).getName());
                if (myChannel.get(i).getTag().contains("zhihu")) {
                    mFragment.add(ZhiHuDailyFragment.newInstance());
                } else {
                    mFragment.add(WangyiNewsFragment.newInstance(myChannel.get(i).getTag()));
                }

            }
        } else {
            if (mTitle != null && mFragment != null) {
                mTitle.clear();
                mFragment.clear();
            }
            if (mTitle != null) {
                mTitle.add("热点");
                mTitle.add("科技");
                mTitle.add("娱乐");
                mTitle.add("精选");
            }
            mFragment.add(WangyiNewsFragment.newInstance("T1348647909107"));
            mFragment.add(WangyiNewsFragment.newInstance("T1348649580692"));
            mFragment.add(WangyiNewsFragment.newInstance("T1348648517839"));
            mFragment.add(WangyiNewsFragment.newInstance("T1467284926140"));

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                Intent intent = new Intent(getContext(), ChannelActivity.class);
                intent.putExtra("type", "news");
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
