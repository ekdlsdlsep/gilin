package com.example.gilin.hyelin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.dain.Login;
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.databinding.FragmentSulzzungBinding;
import com.example.gilin.hani.mypage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sulzzung extends Fragment {

    private FragmentSulzzungBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSulzzungBinding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.hideBottomNav();
        }

        binding.sulzzungBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new mypage());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        binding.sulzzungPasswordReset1.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new Passworld());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.sulzzungPasswordReset2.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new Passworld());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.sulzzungDeleteId1.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new gaejung_bye());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.sulzzungDeleteId2.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new gaejung_bye());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.sulzzungLogout1.setOnClickListener(v -> showLogoutDialog());
        binding.sulzzungLogout2.setOnClickListener(v -> showLogoutDialog());

        binding.sulzzungSave.setOnClickListener(v -> {
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("로그아웃");
        builder.setMessage("정말 로그아웃 하시겠습니까?");
        builder.setPositiveButton("네", (dialog, which) -> {

            Toast.makeText(requireContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new Login());
            fragmentTransaction.commit();
            PreferenceUtil.setLoginStatus(getActivity(), "x");
        });
        builder.setNegativeButton("아니요", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
