package com.hhx.pureNews.modules.zhihu.mvp;

/**
 * Created by hhx on 2017/7/31.
 */

public interface ZhihuArticleContract {

    interface View {
        void loadFail();
        void loadSucess(ZhihuArticle zhihuArticle);
    }

    interface Presenter {
        void loadArticle(int id);
    }
}
