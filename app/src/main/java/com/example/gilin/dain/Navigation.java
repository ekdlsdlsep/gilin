package com.example.gilin.dain;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gilin.R;
import com.example.gilin.databinding.FragmentNavigationBinding;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;

public class Navigation extends Fragment {

    private FragmentNavigationBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View Binding 초기화
        binding = FragmentNavigationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        TMapView tMapView = new TMapView(getActivity());

        // TmapView 초기화
        tMapView.setSKTMapApiKey("nJ7Ow1IJsE9Ggety0DRt23zvw113CQ872NBBjquF");
        binding.linearLayoutNavigation.addView(tMapView);

        TMapData tmapdata = new TMapData();
        TMapPolyLine tpolyline = new TMapPolyLine();
        tMapView.addTMapPath(tpolyline);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
