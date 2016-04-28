package com.istconsultinggroup.mobile.movinon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BoothDetailActivity extends AppCompatActivity {

    private int index;
    private Activity parentActivity;
    public final static String INDEX = "INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.istconsultinggroup.mobile.movinon.R.layout.activity_booth_detail);
        Toolbar toolbar = (Toolbar) findViewById(com.istconsultinggroup.mobile.movinon.R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        index = intent.getIntExtra("Index", 0);
        parentActivity = this;
        String[] artists = this.getResources().getStringArray(com.istconsultinggroup.mobile.movinon.R.array.booths);
        getSupportActionBar().setTitle(artists[index]);

        //TextView time = (TextView) this.findViewById(R.id.timelabel);
        //String[] times = this.getResources().getStringArray(R.array.times);
        //time.setText(times[index]);

        TextView description = (TextView) this.findViewById(com.istconsultinggroup.mobile.movinon.R.id.artistdesc);
        CardView location_card = (CardView) this.findViewById(R.id.location_card);
        location_card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(parentActivity, MainActivity.class);
                intent.putExtra(INDEX, 1);
                parentActivity.startActivity(intent);
            }
        });
        String[] descriptions = this.getResources().getStringArray(com.istconsultinggroup.mobile.movinon.R.array.booth_descriptions);
        description.setText(descriptions[index]);

        //ImageView header = (ImageView) this.findViewById(R.id.artist_header);
        //TypedArray images = this.getResources().obtainTypedArray(R.array.banners);
        //header.setImageResource(images.getResourceId(index, R.drawable.artist));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
