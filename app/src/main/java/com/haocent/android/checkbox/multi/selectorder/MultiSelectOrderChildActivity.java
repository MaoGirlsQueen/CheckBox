package com.haocent.android.checkbox.multi.selectorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.haocent.android.checkbox.R;

import java.util.ArrayList;

/**
 * 多选（选择的顺序）选择的内容
 *
 * Created by Tnno Wu on 2018/01/05.
 */

public class MultiSelectOrderChildActivity extends AppCompatActivity {

    private static final String TAG = MultiSelectOrderChildActivity.class.getSimpleName();

    private MultiSelectOrderChildAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_select_order_child);

        ArrayList<String> list = getIntent().getStringArrayListExtra("select_name");

        mAdapter = new MultiSelectOrderChildAdapter(this, list);

        RecyclerView recyclerView = findViewById(R.id.rcv_multi_select_order_child);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
