package com.istconsultinggroup.mobile.movinon;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> {

    List<String> mListData;
    List<String> mTimeData;
    Activity parentActivity;



    public ArtistAdapter(Activity parentActivity) {
        Resources res = parentActivity.getResources();
        String[] artists = res.getStringArray(R.array.artists);
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, artists);
        String[] listTimes = res.getStringArray(R.array.times);
        List<String> listTime = new ArrayList<String>();
        Collections.addAll(listTime, listTimes);

        this.mListData = list;
        this.mTimeData = listTime;
        this.parentActivity = parentActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artist_item,
                viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {

        TypedArray images = this.parentActivity.getResources().obtainTypedArray(R.array.banners);
        myViewHolder.artist.setText(mListData.get(i));
        myViewHolder.setTime.setText(mTimeData.get(i));
        //myViewHolder.artist.setTypeface(myViewHolder.font);
        //myViewHolder.setTime.setTypeface(myViewHolder.font);
        myViewHolder.artistPic.setImageResource(images.getResourceId(i, R.drawable.photo));
        myViewHolder.moreInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(parentActivity, ArtistDetailActivity.class);
                intent.putExtra("Index", i);
                parentActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView artist;
        ImageView artistPic;
        Typeface font;
        TextView setTime;
        Button moreInfo;

        public MyViewHolder(View itemView) {
            super(itemView);

            artist = (TextView) itemView.findViewById(R.id.listitem_name);
            artistPic = (ImageView) itemView.findViewById(R.id.imageView);
            setTime = (TextView) itemView.findViewById(R.id.text2);
            moreInfo = (Button) itemView.findViewById(R.id.moreinfo);

        }
    }

}

