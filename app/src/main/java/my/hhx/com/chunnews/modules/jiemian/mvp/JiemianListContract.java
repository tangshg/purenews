package my.hhx.com.chunnews.modules.jiemian.mvp;

import java.util.List;

/**
 * Created by hhx on 2017/5/27.
 */

public interface JiemianListContract {
    interface View {
        void initView();

        void refreshFail();

        void refreshData();

        void refreshSuccess(List<Jiemian.ResultBean.ListBean> listBeen);

        void loadMoreSuccess(List<Jiemian.ResultBean.ListBean> listBeen);

        void loadMoreFail();


    }

    interface Presenter {
        void loadData();

        void loadCache();

        void refreshData();
    }
}
