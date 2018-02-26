package com.hhx.pureNews.modules.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hhx.pureNews.R;
import com.hhx.pureNews.util.DataCleanUtils;

/**
 * Created by hhx on 17-9-10.
 */

public class SettingFragment extends Fragment {
    @BindView(R.id.setting_toolbar)
    Toolbar settingToolbar;
    @BindView(R.id.setting_cache_tv)
    TextView settingCacheTv;
    @BindView(R.id.setting_cache_fl)
    FrameLayout settingCacheFl;
    Unbinder unbinder;
    @BindView(R.id.setting_theme_fl)
    FrameLayout settingThemeFl;
    @BindView(R.id.setting_text_tv)
    TextView settingTextTv;
    @BindView(R.id.setting_text_fl)
    FrameLayout settingTextFl;
    private View mView;
    private AlertDialog.Builder builder;
    private CacheUtils cacheUtil;
    private String textSize = null;

    public static SettingFragment newInstance() {

        return new SettingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_setting, container, false);
        unbinder = ButterKnife.bind(this, mView);
        cacheUtil = CacheUtils.getInstance();
        if (cacheUtil.getString("textSize") != null) {
            textSize = cacheUtil.getString("textSize");
        }

        if (textSize != null) {
            settingTextTv.setText(textSize);
        } else {
            settingTextTv.setText("标准");
        }

        settingToolbar.setTitle("设置");
        settingToolbar.setNavigationIcon(R.drawable.ic_menu_menu);
        ((AppCompatActivity) getActivity()).setSupportActionBar(settingToolbar);
        settingToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    private void init() {
        try {
            settingCacheTv.setText(DataCleanUtils.getTotalCacheSize(getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.setting_cache_fl, R.id.setting_theme_fl, R.id.setting_text_fl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_cache_fl:
                settingCacheTv.setText("0");
                DataCleanUtils.clearAllCache(getContext());
                break;
            case R.id.setting_theme_fl:
                Intent intent = new Intent(getContext(), ThemeActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_text_fl:
                showSingleChoiceDialog(view);
                break;
            default:
                break;

        }
    }

    private void showSingleChoiceDialog(View view) {
        builder = new AlertDialog.Builder(getContext());

        builder.setTitle("字号选择");

        /**
         * 设置内容区域为单选列表项
         */
        cacheUtil = CacheUtils.getInstance();
        String a = cacheUtil.getString("textSize");

        final String[] items = {"小号", "标准", "大号"};
        int i;
        if (a != null) {
            if (a.contains("小号")) {
                i = 0;
            } else if (a.contains("标准")) {
                i = 1;
            } else {
                i = 2;
            }
        } else {
            i = 1;
        }


        builder.setSingleChoiceItems(items, i, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    settingTextTv.setText("小号");
                    cacheUtil.put("textSize", "小号");

                } else if (i == 1) {
                    settingTextTv.setText("标准");
                    cacheUtil.put("textSize", "标准");
                } else {
                    settingTextTv.setText("大号");
                    cacheUtil.put("textSize", "大号");
                }
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
