package com.blqy.scheduledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePopupWindow;
import com.blqy.scheduledemo.Bean.ScheInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.tv_choose_date)
    TextView tvChooseDate;
    @Bind(R.id.et_title)
    EditText etTitle;
    @Bind(R.id.et_context)
    EditText etContext;
    @Bind(R.id.tv_select_date)
    TextView tvSelectDate;
    @Bind(R.id.et_long)
    EditText etLong;
    @Bind(R.id.btn_save)
    Button btnSave;
    @Bind(R.id.btn_cancel)
    Button btnCancel;
    private TimePopupWindow pwTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_schedule);
        ButterKnife.bind(this);

        initViews();
        setAllClick();
    }

    private void setAllClick() {
        tvSelectDate.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    private void initViews() {
        int cYear, cMonth, cDate;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        cYear = extras.getInt("year");
        cMonth = extras.getInt("month");
        cDate = extras.getInt("date");
        String strDate = cYear + "年" + cMonth + "月" + cDate + "日";
        tvChooseDate.setText(strDate);

        pwTime = new TimePopupWindow(this, TimePopupWindow.Type.HOURS_MINS);
        pwTime.setTime(new Date());
        pwTime.setOnTimeSelectListener(new TimePopupWindow.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                tvSelectDate.setText(getTime(date));
            }
        });

    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Bundle bundle;
        switch (v.getId()) {
            case R.id.tv_select_date:
                pwTime.showAtLocation(tvSelectDate, Gravity.BOTTOM, 0, 0, new Date());
                break;
            case R.id.btn_save:
                Log.e("=========", "btn_save");
                ScheInfo scheInfo = new ScheInfo();
                scheInfo.setStartTime(tvSelectDate.getText().toString());
                scheInfo.setTitle(etTitle.getText().toString());
                scheInfo.setContext(etContext.getText().toString());
                scheInfo.setHoldTime(etLong.getText().toString());
                intent = new Intent();
                bundle = new Bundle();
                bundle.putParcelable("sche", scheInfo);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btnCancel:
                intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
                break;
        }
    }
}
