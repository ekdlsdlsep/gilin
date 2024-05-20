package com.example.gilin.kst;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.gilin.R;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class Map extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        LinearLayout linearLayoutTmap = rootView.findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(getActivity());

        tMapView.setSKTMapApiKey("nJ7Ow1IJsE9Ggety0DRt23zvw113CQ872NBBjquF");
        linearLayoutTmap.addView(tMapView);

        TMapMarkerItem markerItem1 = new TMapMarkerItem();
        TMapPoint tMapPoint1 = new TMapPoint(35.1639211, 126.7975209); // SKT타워

        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.marker);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 90, 100, false);

        markerItem1.setIcon(resizedBitmap);
        markerItem1.setPosition(0.5f, 1.0f);
        markerItem1.setTMapPoint(tMapPoint1);
        markerItem1.setName("");
        tMapView.addMarkerItem("markerItem1", markerItem1);

        tMapView.setCenterPoint(126.7975209, 35.1639211);

        return rootView;
    }
}