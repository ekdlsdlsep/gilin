package com.example.gilin.dain;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.databinding.FragmentGonjiBinding;
import com.example.gilin.databinding.FragmentSearchListBinding;


public class SearchList extends Fragment {

    private FragmentSearchListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSearchListBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

}