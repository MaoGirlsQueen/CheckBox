package com.haocent.android.checkbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.haocent.android.checkbox.invert.InvertActivity;
import com.haocent.android.checkbox.multi.MultiActivity;
import com.haocent.android.checkbox.selectall.SelectAllActivity;
import com.haocent.android.checkbox.single.SingleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        CardView cvSingle = findViewById(R.id.cv_single);
        CardView cvMulti = findViewById(R.id.cv_multi);
        CardView cvInvert = findViewById(R.id.cv_invert);
        CardView cvSelectAll = findViewById(R.id.cv_select_all);

        cvSingle.setOnClickListener(this);
        cvMulti.setOnClickListener(this);
        cvInvert.setOnClickListener(this);
        cvSelectAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_single:        // 单选
                Intent intentSingle = new Intent(this, SingleActivity.class);
                startActivity(intentSingle);
                break;
            case R.id.cv_multi:         // 多选
                Intent intentMulti = new Intent(this, MultiActivity.class);
                startActivity(intentMulti);
                break;
            case R.id.cv_invert:        // 反选
                Intent intentInvert = new Intent(this, InvertActivity.class);
                startActivity(intentInvert);
                break;
            case R.id.cv_select_all:    // 全选
                Intent intentSelectAll = new Intent(this, SelectAllActivity.class);
                startActivity(intentSelectAll);
                break;
            default:
                break;
        }
    }
}
