package com.example.gilin.hyelin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.databinding.FragmentLoginBinding;
import com.example.gilin.databinding.FragmentSulzzungBinding;

public class sulzzung extends Fragment {

    private FragmentSulzzungBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSulzzungBinding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.hideBottomNav();
        }
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.showBottomNav();
        }
    }
}