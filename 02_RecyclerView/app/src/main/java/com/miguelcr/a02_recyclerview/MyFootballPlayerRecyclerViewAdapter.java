package com.miguelcr.a02_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyFootballPlayerRecyclerViewAdapter extends RecyclerView.Adapter<MyFootballPlayerRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<FootballPlayer> mValues;

    public MyFootballPlayerRecyclerViewAdapter(Context ctx, List<FootballPlayer> items) {
        this.ctx = ctx;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_footballplayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewName.setText(holder.mItem.getName());
        holder.textViewAge.setText(String.valueOf(holder.mItem.getAge()));

        Picasso.with(ctx).load(holder.mItem.getPhotoPath()).into(holder.imageViewPhoto);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView imageViewPhoto;
        public final TextView textViewName;
        public final TextView textViewAge;
        public FootballPlayer mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
            textViewAge = (TextView) view.findViewById(R.id.textViewAge);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + "'";
        }
    }
}
