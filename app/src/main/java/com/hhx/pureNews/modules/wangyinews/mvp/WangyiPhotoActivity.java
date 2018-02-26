package com.hhx.pureNews.modules.wangyinews.mvp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.target.Target;
import com.github.anzewei.parallaxbacklayout.ParallaxBack;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;
import com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import com.hhx.pureNews.GlideApp;
import com.hhx.pureNews.R;
import com.hhx.pureNews.ui.MyViewPager;

import static com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout.EDGE_MODE_DEFAULT;
@ParallaxBack
public class WangyiPhotoActivity extends AppCompatActivity implements WangyiPhotoContract.View, View.OnClickListener {

    @BindView(R.id.wangyi_photo_title_tv)
    TextView wangyiPhotoTitleTv;
    @BindView(R.id.wangyi_photo_content_tv)
    TextView wangyiPhotoContentTv;
    @BindView(R.id.wangyi_photo_num_tv)
    TextView wangyiPhotoNumTv;
    @BindView(R.id.wangyi_photo_download_iv)
    ImageView wangyiPhotoDownloadIv;
    Unbinder unbinder;
    @BindView(R.id.wangyi_photo_view_pager)
    MyViewPager wangyiPhotoViewPager;
    private String mId;
    private String mId1;
    private String mId2;
    private WangyiPhotoPresenter wangyiPhotoPresenter = new WangyiPhotoPresenter(this);
    private List<String> mContent = new ArrayList<>();
    private List<String> mImg = new ArrayList<>();
    private List<Fragment> mFragment = new ArrayList<>();
    private int mCurrent = 1;
    private int mTotal;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangyi_photo);
        ParallaxBackLayout layout = ParallaxHelper.getParallaxBackLayout(this, true);
        layout.setEdgeMode(EDGE_MODE_DEFAULT);//边缘滑动
        layout.setScrollThresHold((float) 0.15);
        unbinder = ButterKnife.bind(this);
        mId = getIntent().getStringExtra("id");
        wangyiPhotoDownloadIv.setOnClickListener(this);
        loadPhotoSet();


    }

    private void initVIewPager() {
        wangyiPhotoViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        });

        wangyiPhotoViewPager.setOffscreenPageLimit(3);
        wangyiPhotoViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mCurrent = position + 1;
                wangyiPhotoContentTv.setText(mContent.get(position));
                wangyiPhotoNumTv.setText((position + 1) + "/" + mTotal);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadPhotoSet() {

        mId1 = mId.substring(4, 8);
        mId2 = mId.substring(9, mId.length());
        wangyiPhotoPresenter.loadPhotoSet(mId1, mId2);

    }

    @Override
    public void loadFail() {

    }

    @Override
    public void loadSucess(WangyiPhoto wangyiPhoto) {
        mName = wangyiPhoto.getSetname();
        mTotal = wangyiPhoto.getPhotos().size();
        for (int i = 0; i < wangyiPhoto.getPhotos().size(); i++) {
            Fragment fragment = WangyiPhotoFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString("image_url", wangyiPhoto.getPhotos().get(i).getImgurl());
            fragment.setArguments(bundle);
            mImg.add(wangyiPhoto.getPhotos().get(i).getImgurl());
            mContent.add(wangyiPhoto.getPhotos().get(i).getNote());
            mFragment.add(fragment);
        }
        wangyiPhotoTitleTv.setText(mName);
        wangyiPhotoNumTv.setText(mCurrent + "/" + mTotal);
        wangyiPhotoContentTv.setText(mContent.get(0));
        initVIewPager();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        String url = mImg.get(mCurrent - 1);
        Flowable.just(url)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        try {
                            Bitmap bitmap = null;
                            bitmap = GlideApp
                                    .with(getApplicationContext())
                                    .asBitmap()
                                    .load(s)
                                    .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                    .get();
                            MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "最新闻", "图片保存");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                });


        Toast.makeText(this, "图片保存成功", Toast.LENGTH_SHORT).show();
    }
}
