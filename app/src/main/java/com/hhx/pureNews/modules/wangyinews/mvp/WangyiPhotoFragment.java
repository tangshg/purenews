package com.hhx.pureNews.modules.wangyinews.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hhx.pureNews.R;

/**
 * Created by hhx on 17-9-7.
 */

public class WangyiPhotoFragment extends Fragment {
    @BindView(R.id.wangyi_photo_view)
    PhotoView wangyiPhotoView;
    Unbinder unbinder;
    private String mImgUrl;

    public static WangyiPhotoFragment newInstance() {
        return new WangyiPhotoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wangyi_photo, container, false);

        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mImgUrl = bundle.getString("image_url");
        }
        Glide.with(this).load(mImgUrl).into(wangyiPhotoView);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
