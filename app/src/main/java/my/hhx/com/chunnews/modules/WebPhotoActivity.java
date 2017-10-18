package my.hhx.com.chunnews.modules;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
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
import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import my.hhx.com.chunnews.GlideApp;
import my.hhx.com.chunnews.R;
import my.hhx.com.chunnews.ui.MyViewPager;

import static com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout.EDGE_MODE_DEFAULT;

@ParallaxBack
public class WebPhotoActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.web_photo_view_pager)
    MyViewPager webPhotoViewPager;
    @BindView(R.id.web_photo_tv)
    TextView webPhotoTv;
    @BindView(R.id.web_photo_download_iv)
    ImageView webPhotoDownloadIv;
    private PagerAdapter pagerAdapter;

    private List<String> mImgUrlList;
    private List<Fragment> mFragment = new ArrayList<>();
    private String mImgUrl;
    private int mTotal;
    private int mCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_photo);
        ParallaxBackLayout layout = ParallaxHelper.getParallaxBackLayout(this, true);
        layout.setEdgeMode(EDGE_MODE_DEFAULT);//全屏滑动
        layout.setScrollThresHold((float) 0.15);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        webPhotoDownloadIv.setOnClickListener(this);
        mImgUrlList = getIntent().getStringArrayListExtra("image_url_list");
        mImgUrl = getIntent().getStringExtra("image_url");
        mTotal = getIntent().getIntExtra("total", 0);
        mCurrent = getIntent().getIntExtra("current", 0);
        for (int i = 0; i < mImgUrlList.size(); i++) {
            Fragment fragment = WebPhotoFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString("image_url", mImgUrlList.get(i));
            fragment.setArguments(bundle);
            mFragment.add(fragment);
        }

        pagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mImgUrlList.size();
            }
        };
        webPhotoViewPager.setAdapter(pagerAdapter);
        webPhotoViewPager.setCurrentItem(mCurrent - 1);
        webPhotoViewPager.setOffscreenPageLimit(3);
        webPhotoTv.setText(mCurrent + "/" + mTotal);
        webPhotoViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                webPhotoTv.setText((position + 1) + "/" + mTotal);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public void onClick(View view) {
        String url = mImgUrlList.get(mCurrent - 1);


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
                            MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "最新闻", "网页图片保存");
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
