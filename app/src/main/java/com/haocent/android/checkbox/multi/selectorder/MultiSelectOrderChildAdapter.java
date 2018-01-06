package com.haocent.android.checkbox.multi.selectorder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haocent.android.checkbox.R;

import java.util.List;

/**
 * Created by Tnno Wu on 2018/01/05.
 */

public class MultiSelectOrderChildAdapter extends RecyclerView.Adapter<MultiSelectOrderChildAdapter.MultiSelectOrderChildViewHolder> {

    private Context mContext;

    private List<String> mList;

    public MultiSelectOrderChildAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MultiSelectOrderChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_multi_select_order_child, parent, false);
        return new MultiSelectOrderChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MultiSelectOrderChildViewHolder holder, int position) {
        holder.tvName.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MultiSelectOrderChildViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public MultiSelectOrderChildViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_multi_child);
        }
    }
}
