package my.hhx.com.chunnews.modules.setting;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.github.anzewei.parallaxbacklayout.ParallaxBack;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;
import com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import my.hhx.com.chunnews.R;
import skin.support.SkinCompatManager;

import static com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout.EDGE_MODE_FULL;

@ParallaxBack
public class ThemeActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.theme_toolbar)
    Toolbar themeToolbar;
    @BindView(R.id.theme_default_fl)
    FrameLayout themeDefaultFl;
    @BindView(R.id.theme_black_fl)
    FrameLayout themeBlackFl;
    @BindView(R.id.theme_red_fl)
    FrameLayout themeRedFl;
    @BindView(R.id.theme_green_fl)
    FrameLayout themeGreenFl;
    @BindView(R.id.theme_orange_fl)
    FrameLayout themeOrangeFl;
    @BindView(R.id.theme_blue_fl)
    FrameLayout themeBlueFl;
    @BindView(R.id.theme_pink_fl)
    FrameLayout themePinkFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);
        ParallaxBackLayout layout = ParallaxHelper.getParallaxBackLayout(this, true);
        layout.setEdgeMode(EDGE_MODE_FULL);//全屏滑动
        layout.setScrollThresHold((float) 0.3);

        themeToolbar.setTitle("设置");

        setSupportActionBar(themeToolbar);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        themeToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        initView();

    }

    private void initView() {
        themeDefaultFl.setOnClickListener(this);
        themeRedFl.setOnClickListener(this);
        themeGreenFl.setOnClickListener(this);
        themeBlackFl.setOnClickListener(this);
        themeOrangeFl.setOnClickListener(this);
        themeBlueFl.setOnClickListener(this);
        themePinkFl.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.theme_default_fl:
                SkinCompatManager.getInstance().restoreDefaultTheme();
                break;
            case R.id.theme_black_fl:
                SkinCompatManager.getInstance().loadSkin("black", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            case R.id.theme_red_fl:
                SkinCompatManager.getInstance().loadSkin("red", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            case R.id.theme_green_fl:
                SkinCompatManager.getInstance().loadSkin("green", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            case R.id.theme_orange_fl:
                SkinCompatManager.getInstance().loadSkin("orange", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            case R.id.theme_blue_fl:
                SkinCompatManager.getInstance().loadSkin("blue", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            case R.id.theme_pink_fl:
                SkinCompatManager.getInstance().loadSkin("pink", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            default:
        }
    }
}
