package com.haocent.android.checkbox.multi.selectorder;

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

import java.util.ArrayList;
import java.util.List;

/**
 * 多选：选择的顺序
 *
 * Created by Tnno Wu on 2018/01/05.
 */

public class MultiSelectOrderActivity extends AppCompatActivity {

    private List<String> mList = new ArrayList<>();

    private FloatingActionButton mFab;

    private MultiSelectOrderAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_select_order);

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
        RecyclerView recyclerView = findViewById(R.id.rcv_multi_select_order);
        mFab = findViewById(R.id.fab);

        mAdapter = new MultiSelectOrderAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setDataList(mList);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                list.addAll(mAdapter.getSelectList());

                if (list.size() <= 0) {
                    Snackbar.make(mFab, "未选中", Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MultiSelectOrderActivity.this, MultiSelectOrderChildActivity.class);
                    intent.putStringArrayListExtra("select_name", list);
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
