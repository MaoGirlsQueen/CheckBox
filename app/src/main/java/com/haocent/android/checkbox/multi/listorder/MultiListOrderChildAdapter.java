package com.haocent.android.checkbox.multi.listorder;

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

public class MultiListOrderChildAdapter extends RecyclerView.Adapter<MultiListOrderChildAdapter.MultiListOrderChildViewHolder> {

    private Context mContext;

    private List<String> mList;

    public MultiListOrderChildAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MultiListOrderChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_multi_list_order_child, parent, false);
        return new MultiListOrderChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MultiListOrderChildViewHolder holder, int position) {
        holder.tvName.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MultiListOrderChildViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public MultiListOrderChildViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_multi_child);
        }
    }
}
