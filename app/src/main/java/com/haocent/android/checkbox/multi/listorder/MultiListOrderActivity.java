package com.haocent.android.checkbox.multi.listorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.haocent.android.checkbox.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 多选：列表的顺序
 *
 * Created by Tnno Wu on 2018/01/05.
 */

public class MultiListOrderActivity extends AppCompatActivity {

    private static final String TAG = MultiListOrderActivity.class.getSimpleName();

    private List<String> mList = new ArrayList<>();

    private FloatingActionButton mFab;

    private MultiListOrderAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_list_order);

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
        RecyclerView recyclerView = findViewById(R.id.rcv_multi_list_order);
        mFab = findViewById(R.id.fab);

        mAdapter = new MultiListOrderAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setDataList(mList);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<Integer, Boolean> isChecked = mAdapter.getMap();
                List<String> list = new ArrayList<>();
                for (int i = 0; i < mList.size(); i++) {
                    if (isChecked.get(i) != null && isChecked.get(i)) {
                        String name = mList.get(i);
                        list.add(name);
                    }
                }

                if (list.size() <= 0) {
                    Snackbar.make(mFab, "未选中", Snackbar.LENGTH_SHORT).show();
                } else {
                    // 将数据传至下一页
                    Intent intent = new Intent(MultiListOrderActivity.this, MultiListOrderChildActivity.class);
                    intent.putExtra("list_name", (Serializable) (list));
                    startActivity(intent);
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
