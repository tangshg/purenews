package com.hhx.pureNews;

import java.util.List;

/**
 * Created by hhx on 2017/8/26.
 */

public class MessageEvent {
    private String message;
    private String imgurl;
    private List<String> imgUrlList;

    public MessageEvent(String message) {
        this.message = message;
    }

    public MessageEvent(String imgUrl, List<String> imgUrlList) {
        this.imgurl = imgUrl;
        this.imgUrlList = imgUrlList;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public List<String> getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(List<String> imgUrlList) {
        this.imgUrlList = imgUrlList;
    }

    public String getMessage() {
        return message;

    }

    public void setMessage(String message) {
        this.message = message;
    }
}
