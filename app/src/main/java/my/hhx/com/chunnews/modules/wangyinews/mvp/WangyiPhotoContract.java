package my.hhx.com.chunnews.modules.wangyinews.mvp;

/**
 * Created by hhx on 2017/7/31.
 */

public interface WangyiPhotoContract {

    interface View {
        void loadFail();

        void loadSucess(WangyiPhoto wangyiPhoto);
    }

    interface Presenter {
        void loadPhotoSet(String id1, String id2);
    }
}
