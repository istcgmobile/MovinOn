package com.istconsultinggroup.mobile.movinon;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class ArtistFragment extends Fragment {

    private ArtistAdapter mAdapter;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(com.istconsultinggroup.mobile.movinon.R.layout.artist_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(
                com.istconsultinggroup.mobile.movinon.R.id.fragment_list_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        mAdapter = new ArtistAdapter(getActivity());
        recyclerView.setAdapter(mAdapter);



        return view;
    }
}
