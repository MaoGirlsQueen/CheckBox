package com.haocent.android.checkbox.multi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.haocent.android.checkbox.R;
import com.haocent.android.checkbox.multi.listorder.MultiListOrderActivity;
import com.haocent.android.checkbox.multi.selectorder.MultiSelectOrderActivity;

/**
 * CheckBox 多选
 *
 * Created by Tnno Wu on 2018/01/05.
 */

public class MultiActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MultiActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        initView();
    }

    private void initView() {
        CardView cvMultiListOrder = findViewById(R.id.cv_multi_list_order);
        CardView cvMultiSelectOrder = findViewById(R.id.cv_multi_select_order);

        cvMultiListOrder.setOnClickListener(this);
        cvMultiSelectOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_multi_list_order:      // 多选：列表顺序
                Intent intentMultiListOrder = new Intent(this, MultiListOrderActivity.class);
                startActivity(intentMultiListOrder);
                break;
            case R.id.cv_multi_select_order:    // 多选：选择顺序
                Intent intentMultiSelectOrder = new Intent(this, MultiSelectOrderActivity.class);
                startActivity(intentMultiSelectOrder);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
