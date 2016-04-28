package com.istconsultinggroup.mobile.movinon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class ConnectFragment extends Fragment {

    private ArtistAdapter mAdapter;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.connect_fragment, container, false);



        //TextView time = (TextView) view.findViewById(R.id.timelabel);
        //time.setText("Social Media Buttons Here");

        TextView description = (TextView) view.findViewById(R.id.artistdesc);
        //description.setText("Email goes here I guess idk fam");

        ImageView fb = (ImageView) view.findViewById(R.id.facebookicon);
        fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://facebook.com/psumovinonfestival"));
                startActivity(intent);
            }
        });

        ImageView tw = (ImageView) view.findViewById(R.id.twittericon);
        tw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://twitter.com/psumovinon"));
                startActivity(intent);
            }
        });

        ImageView ig = (ImageView) view.findViewById(R.id.instagramicon);
        ig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://instagram.com/psumovinon/"));
                startActivity(intent);
            }
        });

        ImageView istcg = (ImageView) view.findViewById(R.id.clubicon);
        istcg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://twitter.com/ICGPSU"));
                startActivity(intent);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("spotify:user:psumusicfest:playlist:7I4woOB8mJ84ITIjnqoPuK"));
                startActivity(browserIntent);
            }
        });



        return view;
    }
}
