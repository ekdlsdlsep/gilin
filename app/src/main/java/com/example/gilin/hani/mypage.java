package com.example.gilin.hani;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.databinding.FragmentMypageBinding;
import com.example.gilin.hyelin.sulzzung;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mypage extends Fragment {

    private FragmentMypageBinding binding;

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
}
