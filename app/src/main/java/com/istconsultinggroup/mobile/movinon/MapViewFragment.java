package com.istconsultinggroup.mobile.movinon;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapViewFragment extends Fragment implements OnMapReadyCallback{
    private static final String MAP_OPTIONS = "MapOptions";

    public MapViewFragment() {
        // Required empty public constructor

    }

    public static MapViewFragment newInstance(GoogleMapOptions options) {
        MapViewFragment fragment = new MapViewFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        args.putParcelable(MAP_OPTIONS, options);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(com.istconsultinggroup.mobile.movinon.R.layout.fragment_map_view, container, false);

        GoogleMapOptions options = new GoogleMapOptions();
        options.useViewLifecycleInFragment(true);

        SupportMapFragment mMapFragment;
        mMapFragment = SupportMapFragment.newInstance(options);
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.maplayout, mMapFragment);
        fragmentTransaction.commit();

        mMapFragment.getMapAsync(this);



        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
        AppBarLayout appBar = (AppBarLayout) getActivity().findViewById(com.istconsultinggroup.mobile.movinon.R.id.appbarlayout);
        appBar.setExpanded(false);
        }
        else {

        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(40.810970, -77.864955))
                .title("Merchandise")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.merch)));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(40.810790, -77.864410))
                .title("EMS")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.health)));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(40.810750, -77.864210))
                .title("Police")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.police)));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(40.809859, -77.865013))
                .title("Restroom")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom)));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(40.809988, -77.863835))
                .title("Synder's Concessions")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));

        LatLngBounds newarkBounds = new LatLngBounds(
                new LatLng(40.810162, -77.866305),       // South west corner
                new LatLng(40.810544, -77.863322));      // North east corner

        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.overlay))
                .position(new LatLng(40.810390, -77.864820), 210f, 135f)
                .bearing(24);



        GroundOverlay imageOverlay = map.addGroundOverlay(newarkMap);

        map.moveCamera(CameraUpdateFactory.newLatLngBounds(newarkBounds, 15));
    }

}
