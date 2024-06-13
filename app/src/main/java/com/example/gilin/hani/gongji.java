package com.example.gilin.hani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gilin.R;
import com.example.gilin.databinding.FragmentGonjiBinding;
import com.example.gilin.databinding.FragmentJoinBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class gongji extends Fragment {

    private FragmentGonjiBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGonjiBinding.inflate(inflater, container, false);

        binding.gongjiBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new mypage());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        return binding.getRoot();
    }

}