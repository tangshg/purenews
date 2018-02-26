package com.hhx.pureNews.modules.jiemian.mvp;

/**
 * Created by hhx on 2017/5/27.
 */

public interface JiemianArticleContract {
    interface View {
        void loadFail();
        void loadSucess(JiemianArticle.ResultBean resultBean);
    }

    interface Presenter {
        void loadArticle(String newsId);
    }
}
