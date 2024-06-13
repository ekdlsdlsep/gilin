package com.example.gilin.hani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gilin.R;
import com.example.gilin.databinding.FragmentMypageBinding;
import com.example.gilin.databinding.FragmentQnAWriteBinding;


public class QnAWrite extends Fragment {

    private FragmentQnAWriteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQnAWriteBinding.inflate(inflater, container, false);

        binding.qnawriteBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new QnA());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.WriteButton.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new QnA());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return binding.getRoot();
    }
}