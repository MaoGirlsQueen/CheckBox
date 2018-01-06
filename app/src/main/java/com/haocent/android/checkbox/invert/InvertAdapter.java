package com.haocent.android.checkbox.invert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.haocent.android.checkbox.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tnno Wu on 2018/01/05.
 */

public class InvertAdapter extends RecyclerView.Adapter<InvertAdapter.InvertViewHolder> {

    private Context mContext;

    private List<String> mList = new ArrayList<>();

    private HashMap<Integer, Boolean> isSelected = new HashMap<>();

    public InvertAdapter(Context context) {
        mContext = context;
    }

    public void setDataList(List<String> list) {
        mList = list;

        initData();

        notifyDataSetChanged();
    }

    public HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    private void initData() {
        for (int i = 0; i < mList.size(); i++) {
            getIsSelected().put(i, false);
        }
    }

    @Override
    public InvertViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_invert, parent, false);
        return new InvertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InvertViewHolder holder, final int position) {
        holder.tvName.setText(mList.get(position));

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getIsSelected().put(position, isChecked);
            }
        });

        holder.checkBox.setChecked(getIsSelected().get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class InvertViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;
        TextView tvName;

        public InvertViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cb_invert);
            tvName = itemView.findViewById(R.id.tv_name_invert);
        }
    }
}
