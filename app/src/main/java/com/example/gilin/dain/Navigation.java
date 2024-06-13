package com.example.gilin.dain;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gilin.Common;
import com.example.gilin.LogManager;
import com.example.gilin.R;
import com.example.gilin.databinding.ActivityMainBinding;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapLabelInfo;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;
import com.skt.Tmap.poi_item.TMapPOIItem;

import java.util.ArrayList;

public class Navigation extends Fragment implements TMapGpsManager.onLocationChangedCallback, View.OnClickListener {

    // 2024-06-06 안 쓰는 파일. 삭제 예정

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onLocationChange(Location location) {

    }
}