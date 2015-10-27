package com.blqy.scheduledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.calendar_view)
    CalendarPickerView calendarView;
    @Bind(R.id.btn_select)
    Button btnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ButterKnife.bind(this);

        initViews();
        setAllClick();
    }

    private void setAllClick() {
        btnSelect.setOnClickListener(this);
    }

    private void initViews() {
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        Date today = new Date();
        calendarView.init(today, nextYear.getTime())
                .withSelectedDate(today);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Bundle bundle;
        switch (v.getId()) {
            case R.id.btn_select:
                intent = new Intent(CalendarActivity.this, ScheduleTodayActivity.class);
                bundle = new Bundle();
                bundle.putInt("year", calendarView.getSelectedDate().getYear() + 1900);
                bundle.putInt("month", calendarView.getSelectedDate().getMonth() + 1);
                bundle.putInt("date", calendarView.getSelectedDate().getDate());
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}
