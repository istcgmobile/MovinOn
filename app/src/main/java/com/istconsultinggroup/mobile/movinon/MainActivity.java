package com.istconsultinggroup.mobile.movinon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;

import java.util.*;

public class MainActivity extends AppCompatActivity{

    private Context context;
    private int message = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(com.istconsultinggroup.mobile.movinon.R.layout.activity_main);


        setupToolbar();

        Intent intent = getIntent();

        if(intent != null){
            message = intent.getIntExtra(BoothDetailActivity.INDEX, 0);
        }

        setupViewPager();

        setupCollapsingToolbar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.istconsultinggroup.mobile.movinon.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("spotify:user:psumusicfest:playlist:7I4woOB8mJ84ITIjnqoPuK"));
                startActivity(browserIntent);
            }
        });



    }

    private void setupCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(
                com.istconsultinggroup.mobile.movinon.R.id.collapse_toolbar);

        collapsingToolbar.setTitleEnabled(false);
    }

    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(com.istconsultinggroup.mobile.movinon.R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(com.istconsultinggroup.mobile.movinon.R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(com.istconsultinggroup.mobile.movinon.R.id.toolbar);
        //getSupportActionBar().setTitle("");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Font path
        String fontPath = "fonts/movinon-webfont.ttf";

        TextView mTitle = (TextView) toolbar.findViewById(com.istconsultinggroup.mobile.movinon.R.id.toolbar_title);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        mTitle.setTypeface(tf);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrag(new ArtistFragment(), "Lineup");
        adapter.addFrag(new MapViewFragment(), "Map");
        adapter.addFrag(new ExperienceFragment(), "Experience");
        adapter.addFrag(new ConnectFragment(), "Connect");

        viewPager.setAdapter(adapter);

        if(message != 0){
            viewPager.setCurrentItem(message, true);;
        }
    }


    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
