package com.example.android.finalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.finalproject.Object.Post;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendPostActivity extends AppCompatActivity {

    String uid;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDataRef;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_post);

        Intent intent=getIntent();
        uid = intent.getStringExtra("Post");

        mDataRef = FirebaseDatabase.getInstance().getReference().child(uid).child("Posts");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_friend_post);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(FriendPostActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Post,PostViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Post, PostViewHolder>(
                Post.class,
                R.layout.blog_row,
                PostViewHolder.class,
                mDataRef
        ) {
            @Override
            protected void populateViewHolder(PostViewHolder viewHolder, Post model, int position) {

                viewHolder.setTime((DateUtils
                        .getRelativeTimeSpanString(Long.valueOf(model.getTime()), Calendar.getInstance().getTimeInMillis(),DateUtils.MINUTE_IN_MILLIS))
                        .toString());
                viewHolder.setContext(model.getBody());
                viewHolder.setLocation(model.getPlace());
                viewHolder.setImage(getApplicationContext(),model.getFile());

            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);



    }

    @Override
    public void onStop() {
        super.onStop();
    }



    public static class PostViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public PostViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setTime(String time){
            TextView post_time= (TextView) mView.findViewById(R.id.header_time_d);
            post_time.setText(time);
        };

        public void setLocation(String place){
            TextView post_location= (TextView) itemView.findViewById(R.id.header_location_d);
            post_location.setText(place);
        }

        public void setContext(String context){
            TextView post_context = (TextView)itemView.findViewById(R.id.post_detail_d);
            post_context.setText(context);
        }

        public void setImage(Context context, String image){
            ImageView post_photo= (ImageView) itemView.findViewById(R.id.post_photo_d);
            Picasso.with(context).load(image)
                    .into(post_photo);
        }
    }


}
