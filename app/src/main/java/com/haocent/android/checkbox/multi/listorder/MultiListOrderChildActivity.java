package com.haocent.android.checkbox.multi.listorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.haocent.android.checkbox.R;

import java.util.List;

/**
 * 多选（列表的顺序）选择的内容
 *
 * Created by Tnno Wu on 2018/01/05.
 */

public class MultiListOrderChildActivity extends AppCompatActivity {

    private static final String TAG = MultiListOrderChildActivity.class.getSimpleName();

    private MultiListOrderChildAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_list_order_child);

        // 获取上一页传来的数据
        List list = (List) getIntent().getSerializableExtra("list_name");
        Log.d(TAG, "onCreate: " + list.size());

        mAdapter = new MultiListOrderChildAdapter(this, list);

        RecyclerView recyclerView = findViewById(R.id.rcv_multi_list_order_child);
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
