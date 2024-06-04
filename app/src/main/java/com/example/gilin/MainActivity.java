package com.example.gilin;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.gilin.dain.Login;
import com.example.gilin.dain.Navigation;
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.hani.mypage;
import com.example.gilin.kst.Map;
import com.example.gilin.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = binding.bottomNavigation;

        String loginStatus = PreferenceUtil.getLoginStatus(this);
        String userId = PreferenceUtil.getUserId(this);
        Log.d("MyActivity", "Login status: " + loginStatus);
        Log.d("MyActivity", "Login status: " + userId);

        if ("x".equals(loginStatus)) {
            transferTo(new Login());
        } else {
            transferTo(new Navigation());
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.myPage) {
                    transferTo(new mypage());
                    return true;
                }
//                else if (item.getItemId() == R.id.safeBall) {
//                    transferTo(new SafeBall());
//                    return true;
//                } else if (item.getItemId() == R.id.user) {
//                    transferTo(new Login());
//                    return true;
//                } else if (item.getItemId() == R.id.bookMark) {
//                    transferTo(new BookMark());
//                    return true;
//                } else if (item.getItemId() == R.id.report) {
//                    transferTo(new Report());
//                    return true;
//                }
                return false;
            }
        });
    }

    // 네비게이션 숨기는 함수
    public void hideBottomNav() {
        binding.bottomNavigation.setVisibility(View.GONE);
    }

    public void showBottomNav() {
        binding.bottomNavigation.setVisibility(View.VISIBLE);
    }

    void transferTo(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}