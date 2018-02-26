package com.hhx.pureNews.config;

import java.io.Serializable;

/**
 * Created by hhx on 17-9-12.
 */

public class Setting implements Serializable {
    private String textSize;

    public String getTextSize() {
        return textSize;
    }

    public void setTextSize(String textSize) {
        this.textSize = textSize;
    }
}
