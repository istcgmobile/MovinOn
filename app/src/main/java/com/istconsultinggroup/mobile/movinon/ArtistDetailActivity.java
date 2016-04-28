package com.istconsultinggroup.mobile.movinon;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistDetailActivity extends AppCompatActivity {

    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        index = intent.getIntExtra("Index", 0);

        String[] artists = this.getResources().getStringArray(R.array.artists);
        getSupportActionBar().setTitle(artists[index]);

        TextView time = (TextView) this.findViewById(com.istconsultinggroup.mobile.movinon.R.id.timelabel);
        String[] times = this.getResources().getStringArray(com.istconsultinggroup.mobile.movinon.R.array.times);
        time.setText(times[index]);

        TextView description = (TextView) this.findViewById(com.istconsultinggroup.mobile.movinon.R.id.artistdesc);
        String[] descriptions = this.getResources().getStringArray(com.istconsultinggroup.mobile.movinon.R.array.descriptions);
        description.setText(descriptions[index]);

        ImageView header = (ImageView) this.findViewById(com.istconsultinggroup.mobile.movinon.R.id.artist_header);
        TypedArray images = this.getResources().obtainTypedArray(com.istconsultinggroup.mobile.movinon.R.array.banners);
        header.setImageResource(images.getResourceId(index, com.istconsultinggroup.mobile.movinon.R.drawable.photo));

        final String[] artistURL = this.getResources().getStringArray(com.istconsultinggroup.mobile.movinon.R.array.spotify);
        FloatingActionButton fab = (FloatingActionButton) findViewById(com.istconsultinggroup.mobile.movinon.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(artistURL[index]));
                startActivity(browserIntent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
