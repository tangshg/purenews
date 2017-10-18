package my.hhx.com.chunnews;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.squareup.leakcanary.LeakCanary;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;
import skin.support.flycotablayout.app.SkinFlycoTabLayoutInflater;

/**
 * Created by hhx on 2017/5/22.
 */

public class IApplication extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        LeakCanary.install(this);
        sContext = this;
        SkinCompatManager.withoutActivity(this)                         // 基础控件换肤初始化
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .addInflater(new SkinFlycoTabLayoutInflater())
                .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
                .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();
        //滑动返回注册
        registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());


    }

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //layout.setPrimaryColorsId(R.color.md_white_color_code, R.color.colorPrimaryDark);//全局设置主题颜色
                layout.setEnableHeaderTranslationContent(false);
                return new MaterialHeader(context);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
    }


}
