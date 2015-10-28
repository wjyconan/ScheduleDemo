package com.blqy.scheduledemo.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wjy on 2015/10/22.
 */
public class ScheInfo implements Parcelable {
    private String title, context, startTime;
    private String holdTime;

    public ScheInfo(){

    }
    public ScheInfo(Parcel in) {
        title = in.readString();
        context = in.readString();
        startTime = in.readString();
        holdTime = in.readString();
    }

    public static final Creator<ScheInfo> CREATOR = new Creator<ScheInfo>() {
        @Override
        public ScheInfo createFromParcel(Parcel in) {
            return new ScheInfo(in);
        }

        @Override
        public ScheInfo[] newArray(int size) {
            return new ScheInfo[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(context);
        dest.writeString(startTime);
        dest.writeString(holdTime);
    }
}
