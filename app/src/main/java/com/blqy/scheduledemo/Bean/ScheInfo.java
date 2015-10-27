package com.blqy.scheduledemo.Bean;

import java.io.Serializable;

/**
 * Created by wjy on 2015/10/22.
 *
 */
public class ScheInfo implements Serializable {
    private String title,context,startTime;
    private String holdTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(String holdTime) {
        this.holdTime = holdTime;
    }
}
