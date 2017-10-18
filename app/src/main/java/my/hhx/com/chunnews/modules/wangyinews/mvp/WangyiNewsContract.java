package my.hhx.com.chunnews.modules.wangyinews.mvp;

/**
 * Created by hhx on 2017/8/23.
 */

public interface WangyiNewsContract {
    interface View {
        void initView();

        void refreshFail();

        void refreshData();

        void refreshSuccess(WangyiNews wangyiNews);

        void loadMoreSuccess(WangyiNews wangyiNews);

        void loadMoreFail();


    }

    interface Presenter {
        void loadData();

        void loadCache();

        void refreshData();
    }
}
