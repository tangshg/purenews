package my.hhx.com.chunnews.modules.jiemian.mvp;

import my.hhx.com.chunnews.modules.ithome.mvp.IthomeContentItem;

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
