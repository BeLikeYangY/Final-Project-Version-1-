package com.example.android.finalproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.finalproject.FriendPostActivity;
import com.example.android.finalproject.Object.Friend;
import com.example.android.finalproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Yang on 2017/5/1.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

    private ArrayList<Friend> mDataset;
    private Context context;

    public FriendAdapter(ArrayList<Friend> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView circleImageView;
        TextView textView;
        ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.profile_image_friend);
            textView = (TextView)itemView.findViewById(R.id.friend_name);
            imageView = (ImageView) itemView.findViewById(R.id.detailBtn);
        }

    }

    @Override
    public FriendAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                       int viewType) {
        // create a new view
        View v = LayoutInflater.from(context)
                .inflate(R.layout.list_friend, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int j = position;

        Picasso.with(context).load(mDataset.get(position).getImageId()).into(holder.circleImageView);
        holder.textView.setText(mDataset.get(position).getName());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, FriendPostActivity.class);
                intent.putExtra("Post",mDataset.get(j).getUid());
                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
