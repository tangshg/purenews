package com.hhx.pureNews.modules.wangyinews.mvp;

/**
 * Created by hhx on 2017/7/31.
 */

public interface WangyiArticleContract {

    interface View {
        void loadFail();
        void loadSucess(WangyiContent wangyiContent);
    }

    interface Presenter {
        void loadArticle(String id);
    }
}
