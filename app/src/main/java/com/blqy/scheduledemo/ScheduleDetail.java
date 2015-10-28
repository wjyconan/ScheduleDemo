package com.blqy.scheduledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blqy.scheduledemo.Bean.ScheInfo;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScheduleDetail extends AppCompatActivity {

    @Bind(R.id.tv_choose_date)
    TextView tvChooseDate;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_context)
    TextView tvContext;
    @Bind(R.id.tv_startTime)
    TextView tvStartTime;
    @Bind(R.id.tv_long)
    TextView tvLong;
    @Bind(R.id.tv_endTime)
    TextView tvEndTime;

    private String startTime, endTime;
    private int startHour, endHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        ScheInfo scheInfo = extras.getParcelable("itemList");
        int cYear = extras.getInt("year");
        int cMonth = extras.getInt("month");
        int cDate = extras.getInt("date");
        String strDate = cYear + "年" + cMonth + "月" + cDate + "日";
        tvChooseDate.setText(strDate);
        startTime = scheInfo.getStartTime();
        String[] time = startTime.split(":");
        startHour = Integer.parseInt(time[0]);
        endHour = startHour + Integer.parseInt(scheInfo.getHoldTime());
        endTime = endHour + ":" + time[1];
        tvTitle.setText(scheInfo.getTitle());
        tvContext.setText(scheInfo.getContext());
        tvStartTime.setText(startTime);
        tvLong.setText(scheInfo.getHoldTime());
        tvEndTime.setText(endTime);

    }
}
