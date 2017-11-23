package com.test123.retrofitmvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test123.retrofitmvpdemo.pojo.Item;

import java.util.List;

/**
 * Created by pankaj on 22/11/17.
 */

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private List<Item> mItems;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTv;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(android.R.id.text1);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Item item = getItem(getAdapterPosition());

            notifyDataSetChanged();
        }
    }

    public AnswersAdapter(Context context, List<Item> posts) {
        mItems = posts;
        mContext = context;
    }

    @Override
    public AnswersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AnswersAdapter.ViewHolder holder, int position) {

        Item item = mItems.get(position);
        TextView textView = holder.titleTv;
        textView.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<Item> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private Item getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

}