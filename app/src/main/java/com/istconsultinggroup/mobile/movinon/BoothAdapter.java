package com.istconsultinggroup.mobile.movinon;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class BoothAdapter extends RecyclerView.Adapter<BoothAdapter.MyViewHolder> {

    List<String> mListData;
    List<String> mTimeData;
    Activity parentActivity;



    public BoothAdapter(Activity parentActivity) {
        Resources res = parentActivity.getResources();
        String[] artists = res.getStringArray(com.istconsultinggroup.mobile.movinon.R.array.booths);
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, artists);
        String[] listTimes = res.getStringArray(com.istconsultinggroup.mobile.movinon.R.array.booth_descriptions);
        List<String> listTime = new ArrayList<String>();
        Collections.addAll(listTime, listTimes);

        this.mListData = list;
        this.mTimeData = listTime;
        this.parentActivity = parentActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(com.istconsultinggroup.mobile.movinon.R.layout.booth_item,
                viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {

        TypedArray images = this.parentActivity.getResources().obtainTypedArray(com.istconsultinggroup.mobile.movinon.R.array.booth_icons);
        myViewHolder.artist.setText(mListData.get(i));
        myViewHolder.setTime.setText(mTimeData.get(i));
        //myViewHolder.artist.setTypeface(myViewHolder.font);
        //myViewHolder.setTime.setTypeface(myViewHolder.font);
        myViewHolder.artistPic.setImageResource(images.getResourceId(i, com.istconsultinggroup.mobile.movinon.R.drawable.photo));
        myViewHolder.card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(parentActivity, BoothDetailActivity.class);
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
        CardView card;


        public MyViewHolder(View itemView) {
            super(itemView);

            artist = (TextView) itemView.findViewById(com.istconsultinggroup.mobile.movinon.R.id.listitem_name);
            artistPic = (ImageView) itemView.findViewById(com.istconsultinggroup.mobile.movinon.R.id.imageView);
            setTime = (TextView) itemView.findViewById(com.istconsultinggroup.mobile.movinon.R.id.text2);
            card = (CardView) itemView.findViewById(com.istconsultinggroup.mobile.movinon.R.id.exp_card);


        }
    }

}

