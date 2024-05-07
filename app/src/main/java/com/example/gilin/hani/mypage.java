package com.example.gilin.hani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gilin.R;
import com.example.gilin.databinding.FragmentMypageBinding;
import com.example.gilin.hyelin.sulzzung;


public class mypage extends Fragment {

    private FragmentMypageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMypageBinding.inflate(inflater, container, false);

        binding.mypageButton3.setOnClickListener(v -> {
            Fragment sulzzung = new sulzzung();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, sulzzung); // 'fragment_container'는 메인 레이아웃의 프래그먼트 컨테이너 ID입니다.
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}