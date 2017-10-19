package my.hhx.com.chunnews.modules.wangyinews.mvp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheUtils;
import com.bumptech.glide.Priority;
import com.github.anzewei.parallaxbacklayout.ParallaxBack;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;
import com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import my.hhx.com.chunnews.GlideApp;
import my.hhx.com.chunnews.R;
import my.hhx.com.chunnews.modules.WebPhotoActivity;
import my.hhx.com.chunnews.util.WebUtil;

import static com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout.EDGE_MODE_FULL;

@ParallaxBack
public class WangyiArticleActivity extends AppCompatActivity implements WangyiArticleContract.View {


    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.article_fab)
    FloatingActionButton articleFab;
    @BindView(R.id.title)
    TextView title;
    private List<String> mImgUrlList = new ArrayList<>();
    private Unbinder unbind;

    private int mTotal;
    private int mCurrent;
    private String mTitle;
    private WangyiArticlePresenter wangyiArticlePresenter = new WangyiArticlePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangyi_article);
        ParallaxBackLayout layout = ParallaxHelper.getParallaxBackLayout(this, true);
        layout.setEdgeMode(EDGE_MODE_FULL);//全屏滑动
        layout.setScrollThresHold((float) 0.3);
        unbind = ButterKnife.bind(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webview != null) {
            ViewParent parent = webview.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(webview);
            }
            webview.removeAllViews();
            webview.destroy();
            webview = null;
        }
        unbind.unbind();
    }

    private void initView() {

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        CacheUtils cacheUtil = CacheUtils.getInstance();
        String textSize = null;
        if (cacheUtil.getString("textSize") != null) {
            textSize = cacheUtil.getString("textSize");
        }

        if (textSize != null) {
            switch (textSize) {
                case "小号":
                    webSettings.setTextZoom(100);
                    break;
                case "标准":
                    webSettings.setTextZoom(110);
                    break;
                case "大号":
                    webSettings.setTextZoom(120);
                    break;
                default:
                    break;
            }
        } else {
            webSettings.setTextZoom(110);
        }
        webSettings.setUseWideViewPort(true);

        webview.setWebChromeClient(new WebChromeClient());
//        wangyiArticleWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        wangyiArticleWebView.setVerticalScrollBarEnabled(true);
        webview.addJavascriptInterface(new WangyiJsInterface(), "wangyiArticleActivity");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

            @Override
            public void onPageFinished(WebView webView, String s) {

                Log.e("startweb", "onPageFinished");
                webview.loadUrl("javascript:(function(){" +
                        "var objs = document.getElementsByTagName(\"img\"); " +
                        "for(var i=0;i<objs.length;i++)  " +
                        "{"
                        + "    objs[i].onclick=function()  " +
                        "    {  "
                        + "        window.wangyiArticleActivity.startWebPhotoActivity(this.src);  " +
                        "    }  " +
                        "}" +
                        "})()");

                super.onPageFinished(webView, s);
            }
        });
        loadArticle();
    }

    private void loadArticle() {
        setTitle(null);
        GlideApp.with(this)
                .load(getIntent().getStringExtra("image"))
                .priority(Priority.HIGH)
                .into(backdrop);
        mTitle=getIntent().getStringExtra("title");
        title.setText(mTitle);
        String id = getIntent().getStringExtra("id");
        wangyiArticlePresenter.loadArticle(id);
    }

    @Override
    public void loadFail() {

    }

    @Override
    public void loadSucess(WangyiContent wangyiContent) {
        if (wangyiContent != null) {
            String html = wangyiContent.getContent().getBody();
            html = WebUtil.buildHtmlForWangyi(html, wangyiContent.getContent().getImg(), wangyiContent.getContent().getVideo(), false);
            webview.loadDataWithBaseURL(WebUtil.BASE_URL, html, WebUtil.MIME_TYPE, WebUtil.ENCODING, WebUtil.WANGYI_FAIL_URL);
            mTotal = wangyiContent.getContent().getImg().size();
            for (int i = 0; i < wangyiContent.getContent().getImg().size(); i++) {
                mImgUrlList.add(wangyiContent.getContent().getImg().get(i).getSrc());
            }
        }

    }

    @OnClick(R.id.article_fab)
    public void onViewClicked() {
        Intent share_intent = new Intent();
        String share=getIntent().getStringExtra("share");
        share_intent.setAction(Intent.ACTION_SEND);//设置分享行为
        share_intent.setType("text/plain");//设置分享内容的类型
        share_intent.putExtra(Intent.EXTRA_SUBJECT, "我在纯新闻看:"+mTitle+"  "+share);//添加分享内容标题
        share_intent.putExtra(Intent.EXTRA_TEXT, "我在纯新闻看:"+mTitle+"  "+share);//添加分享内容
        //创建分享的Dialog
        share_intent = Intent.createChooser(share_intent, "分享");
        startActivity(share_intent);


    }


    public class WangyiJsInterface {
        @JavascriptInterface
        public void startWebPhotoActivity(String imageUrl) {
            for (int i = 0; i < mImgUrlList.size(); i++) {
                if (mImgUrlList.get(i).contains(imageUrl)) {
                    mCurrent = i + 1;
                    break;
                }
            }
            Intent intent = new Intent(WangyiArticleActivity.this, WebPhotoActivity.class);
            intent.putExtra("image_url", imageUrl);
            intent.putStringArrayListExtra("image_url_list", (ArrayList<String>) mImgUrlList);
            intent.putExtra("total", mTotal);
            intent.putExtra("current", mCurrent);
            startActivity(intent);
        }
    }


}
