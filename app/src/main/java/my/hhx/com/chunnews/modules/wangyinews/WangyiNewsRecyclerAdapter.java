package my.hhx.com.chunnews.modules.wangyinews;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import my.hhx.com.chunnews.GlideApp;
import my.hhx.com.chunnews.R;
import my.hhx.com.chunnews.modules.wangyinews.mvp.WangyiArticleActivity;
import my.hhx.com.chunnews.modules.wangyinews.mvp.WangyiNews;
import my.hhx.com.chunnews.modules.wangyinews.mvp.WangyiPhotoActivity;
import my.hhx.com.chunnews.util.GlideImageLoader;

/**
 * Created by hhx on 2017/8/23.
 */

public class WangyiNewsRecyclerAdapter extends BaseMultiItemQuickAdapter<WangyiNews.Bean, BaseViewHolder> {
    public WangyiNewsRecyclerAdapter(@Nullable List<WangyiNews.Bean> data) {
        super(data);
        addItemType(WangyiNews.Bean.BANNER, R.layout.banner_item);
        addItemType(WangyiNews.Bean.ITEM, R.layout.zhihu_item);


    }

    @Override
    protected void convert(BaseViewHolder helper, final WangyiNews.Bean item) {
        switch (helper.getItemViewType()) {
            case WangyiNews.Bean.BANNER:
                List<String> imageList = new ArrayList<>();
                List<String> titleList = new ArrayList<>();
                imageList.add(item.getImgsrc());
                titleList.add(item.getTitle());
                if (item.getAds() != null) {
                    for (int i = 0; i < item.getAds().size(); i++) {
                        imageList.add(item.getAds().get(i).getImgsrc());
                        titleList.add(item.getAds().get(i).getTitle());
                    }


                }


                Banner banner = (Banner) helper.getView(R.id.banner);
                //设置banner样式
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                //设置图片加载器
                banner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                banner.setImages(imageList);
                //设置banner动画效果
                banner.setBannerAnimation(Transformer.DepthPage);
                //设置标题集合（当banner样式有显示title时）
                banner.setBannerTitles(titleList);
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
                        //第一个是特殊的，后面都是photoset
                        if (position == 0) {
                            if (item.getSkipType() != null && item.getSkipType().contains("photoset")) {
                                Intent intent = new Intent(mContext, WangyiPhotoActivity.class);
                                intent.putExtra("id", item.getSkipID());
                                mContext.startActivity(intent);

                            } else {
                                Intent intent = new Intent(mContext, WangyiArticleActivity.class);
                                intent.putExtra("id", item.getPostid());
                                intent.putExtra("image", item.getImgsrc());
                                intent.putExtra("title", item.getTitle());
                                mContext.startActivity(intent);

                            }
                        } else {
                            if (item.getAds().get(position - 1).getSkipType() != null && item.getAds().get(position - 1).getSkipType().contains("photoset")) {
                                Intent intent = new Intent(mContext, WangyiPhotoActivity.class);
                                intent.putExtra("id", item.getAds().get(position - 1).getSkipID());
                                mContext.startActivity(intent);
                            } else {
                                Intent intent = new Intent(mContext, WangyiArticleActivity.class);
                                intent.putExtra("id", item.getAds().get(position - 1).getSkipID());
                                intent.putExtra("image", item.getAds().get(position - 1).getImgsrc());
                                intent.putExtra("title", item.getAds().get(position - 1).getTitle());
                                mContext.startActivity(intent);
                            }


                        }


                    }
                });

                break;
            case WangyiNews.Bean.ITEM:
                GlideApp.with(mContext).load(item.getImgsrc()).centerCrop().into((ImageView) helper.getView(R.id.zhihu_daily_item_iv));
//                if (item.getRead() != 1) {
//
//                }
                helper.setText(R.id.zhihu_daily_item_title_tv, item.getTitle());
                helper.setText(R.id.zhihu_daily_item_time_tv, item.getMtime());
                helper.setText(R.id.news_source, item.getSource());
                break;
            default:
                break;
        }
    }
}
