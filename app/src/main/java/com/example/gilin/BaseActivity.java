package com.example.gilin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.gilin.hani.mypage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout contentView = null;
    private static Context mCtx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        mCtx = this;
        contentView = findViewById(R.id.contentView);

        // BottomNavigationView 초기화
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void setContentView(int res) {
        contentView.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        View item = inflater.inflate(res, null);
        contentView.addView(item, new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setContentView(View view) {
        contentView.removeAllViews();
        contentView.addView(view, new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    public void addView(View v) {
        contentView.removeAllViews();
        contentView.addView(v, new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void onClick(View v) {
        // 클릭 이벤트 처리
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Fragment selectedFragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.myPage) {
            selectedFragment = new mypage();
            LinearLayout linearLayout = findViewById(R.id.base_top);
            linearLayout.setVisibility(View.GONE);

        } else if (itemId == R.id.a) {

        } else if (itemId == R.id.b) {

        } else if (itemId == R.id.d) {

        } else if (itemId == R.id.e) {
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contentView, selectedFragment).commit();
        }

        return true;
    }
}
