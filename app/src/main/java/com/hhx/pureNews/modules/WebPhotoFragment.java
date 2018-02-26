package com.hhx.pureNews.modules;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hhx.pureNews.GlideApp;
import com.hhx.pureNews.R;

/**
 * Created by hhx on 17-9-2.
 */

public class WebPhotoFragment extends Fragment {

    @BindView(R.id.web_photo_view)
    PhotoView webPhotoView;

    Unbinder unbinder;
    private String mImgUrl;

    public static WebPhotoFragment newInstance() {

        return new WebPhotoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_photo, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mImgUrl = bundle.getString("image_url");
        }
        if (mImgUrl.toUpperCase().endsWith(".GIF")) {
            GlideApp.with(this).asGif().load(mImgUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(webPhotoView);
        } else {
            Glide.with(this).load(mImgUrl).into(webPhotoView);

        }


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
