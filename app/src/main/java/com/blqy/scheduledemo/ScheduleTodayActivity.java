package com.blqy.scheduledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.blqy.scheduledemo.Bean.ScheInfo;
import com.blqy.scheduledemo.adpt.ScheListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScheduleTodayActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.lv_schedule)
    ListView lvSchedule;
    @Bind(R.id.btn_new_schedule)
    Button btnNewSchedule;
    private int year;
    private int month;
    private int date;
    private List<ScheInfo> list;
    private ScheListAdapter scheListAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_today);
        ButterKnife.bind(this);

        initViews();
        setAllClick();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1&&resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            ScheInfo scheInfo = (ScheInfo) bundle.getSerializable("sche");
            list.add(scheInfo);
            scheListAdapter  = new ScheListAdapter(list, this);
            lvSchedule.setAdapter(scheListAdapter);
        }

    }

    private void setAllClick() {
        btnNewSchedule.setOnClickListener(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        year = extras.getInt("year");
        month = extras.getInt("month");
        date = extras.getInt("date");

    }

    private void initViews() {
        list = new ArrayList<>();
        ScheInfo scheInfo = new ScheInfo();
        scheInfo.setTitle("test title");
        scheInfo.setStartTime("16:30");
        list.add(scheInfo);
        scheListAdapter  = new ScheListAdapter(list, this);
        lvSchedule.setAdapter(scheListAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Bundle bundle;
        switch (v.getId()) {
            case R.id.btn_new_schedule:
                intent = new Intent(ScheduleTodayActivity.this, NewScheduleActivity.class);
                bundle = new Bundle();
                bundle.putInt("year", year);
                bundle.putInt("month", month);
                bundle.putInt("date", date);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
                break;
        }
    }
}
