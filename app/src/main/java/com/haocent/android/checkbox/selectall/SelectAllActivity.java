package com.haocent.android.checkbox.selectall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.haocent.android.checkbox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * CheckBox 全选
 *
 * Created by Tnno Wu on 2018/01/05.
 */

public class SelectAllActivity extends AppCompatActivity {

    private static final String TAG = SelectAllActivity.class.getSimpleName();

    private List<String> mList = new ArrayList<>();

    private FloatingActionButton mFab;

    private SelectAllAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

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
        RecyclerView recyclerView = findViewById(R.id.rcv_select_all);
        mFab = findViewById(R.id.fab);

        mAdapter = new SelectAllAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setDataList(mList);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 遍历 list 的长度，将 SelectAllAdapter 中的 map 值全部设为true
                for (int i = 0; i < mList.size(); i++) {
                    mAdapter.getIsSelected().put(i, true);
                }
                // 刷新 RecyclerView
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
