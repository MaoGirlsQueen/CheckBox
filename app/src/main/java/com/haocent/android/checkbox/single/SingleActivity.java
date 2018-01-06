package com.haocent.android.checkbox.single;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.haocent.android.checkbox.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * CheckBox 单选
 *
 * Created by Tnno Wu on 2018/01/04.
 */

public class SingleActivity extends AppCompatActivity {

    private static final String TAG = SingleActivity.class.getSimpleName();

    private List<String> mList = new ArrayList<>();

    private FloatingActionButton mFab;

    private SingleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        addData();

        initView();
    }

    private void addData() {
        mList.add("Ark: Survival Evolved");
        mList.add("Counter-strike: Global Offensive");
        mList.add("PlayerUnknown’s Battlegrounds");
        mList.add("Divinity: Original Sin II");
        mList.add("The Witcher 3: Wild Hunt");
        mList.add("Warframe");
        mList.add("H1Z1");
        mList.add("Grand Theft Auto V");
        mList.add("Tom Clancy’s Rainbow Six Siege");
        mList.add("DOTA2");
        mList.add("Ghost Recon:Wildlands");
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.rcv_single);
        mFab = findViewById(R.id.fab);

        mAdapter = new SingleAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setDataList(mList);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取当前选中的 CheckBox 的位置
                HashMap<Integer, Boolean> checkPosition = mAdapter.getMap();
                for (int i = 0; i < mList.size(); i++) {
                    if (checkPosition.get(i) != null && checkPosition.get(i)) {
                        Log.d(TAG, "onClick: " + i);

                        // 模拟传值到下一页（这里用提示的形式展示）
                        Snackbar.make(mFab, "选择的是：" + mList.get(i), Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
