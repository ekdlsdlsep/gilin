package com.example.gilin.hani;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.databinding.FragmentMypageBinding;
import com.example.gilin.hyelin.sulzzung;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mypage extends Fragment {

    private FragmentMypageBinding binding;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_NAME = "mypage_nickname";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMypageBinding.inflate(inflater, container, false);

        binding.mypageBack.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });

        binding.mypageProfileImg.setOnClickListener(v -> {
            showMypageDialog();
        });

        binding.mypageNickname.setOnClickListener(v -> {
            showMypageDialog();
        });

        binding.mypageGongji.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new gongji());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.GONE);
            }
        });

        binding.mypageSulzzung.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new sulzzung());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.GONE);
            }
        });

        binding.mypageQna.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new QnA());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.GONE);
            }
        });

        // FragmentResultListener 설정
        getParentFragmentManager().setFragmentResultListener("requestKey", this, (requestKey, result) -> {
            String newName = result.getString("newName");
            if (newName != null) {
                binding.mypageNickname.setText(newName);
                saveNameToPreferences(newName);
            }
        });

        // 저장된 이름 불러오기
        loadNameFromPreferences();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showMypageDialog() {
        MypageDialog dialog = new MypageDialog();
        dialog.show(getParentFragmentManager(), "ProfileImageDialog");
    }

    private void saveNameToPreferences(String name) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.apply();
    }

    private void loadNameFromPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedName = sharedPreferences.getString(KEY_NAME, "홍길동");
        binding.mypageNickname.setText(savedName);
    }
}
