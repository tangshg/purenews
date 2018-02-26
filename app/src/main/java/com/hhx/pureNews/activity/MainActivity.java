package com.hhx.pureNews.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.Toast;


import com.hhx.pureNews.R;
import com.hhx.pureNews.modules.ithome.mvp.IthomeFragment;
import com.hhx.pureNews.modules.jiemian.mvp.JiemianFragment;
import com.hhx.pureNews.modules.news.NewsFragment;
import com.hhx.pureNews.modules.setting.SettingFragment;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends DrawerActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment mIthomeFragment;
    private Fragment mNewsFragment;
    private FragmentManager mFragmentManager;
    private Fragment currentFragment;
    private Fragment mSettingFragment;
    private Fragment mJiemianFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityPermissionsDispatcher.showStorageWithPermissionCheck(this);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void showStorage() {
    }

    @OnShowRationale({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void showRationaleForStorage(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("应用想要正常存储，缓存必须要存储空间授权")
                .setPositiveButton("同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        request.proceed();
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        request.cancel();
                        onDestroy();
                    }
                })
                .show();
    }

    @OnPermissionDenied({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
//一旦用户拒绝了
    void denied() {
        Toast.makeText(this, "真的不给权限吗", Toast.LENGTH_SHORT).show();
        onDestroy();
    }

    @OnNeverAskAgain({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
//用户选择的不再询问
    void notAsk() {
        Toast.makeText(this, "好的不问了", Toast.LENGTH_SHORT).show();
        onDestroy();
    }

    private void initFragment() {
        mNewsFragment = new NewsFragment();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.content_main, mNewsFragment);
        ft.commit();
        currentFragment = mNewsFragment;


    }

    private void initView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_news);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_it_home:
                if (mIthomeFragment == null) {
                    mIthomeFragment = new IthomeFragment();
                }
                replaceFragment(mIthomeFragment);
                currentFragment = mIthomeFragment;
                break;
            case R.id.nav_news:
                if (mNewsFragment == null) {
                    mNewsFragment = new NewsFragment();
                }
                replaceFragment(mNewsFragment);
                currentFragment = mNewsFragment;
                break;
            case R.id.nav_jiemain:
                if (mJiemianFragment == null) {
                    mJiemianFragment = new JiemianFragment();
                }
                replaceFragment(mJiemianFragment);
                currentFragment = mJiemianFragment;
                break;
            case R.id.nav_setting:
                if (mSettingFragment == null) {
                    mSettingFragment = SettingFragment.newInstance();
                }
                replaceFragment(mSettingFragment);
                currentFragment = mSettingFragment;
            default:
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 切换界面
     */
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.hide(currentFragment).show(fragment).commit();
        } else {
            fragmentTransaction.hide(currentFragment).add(R.id.content_main, fragment).commit();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

}
