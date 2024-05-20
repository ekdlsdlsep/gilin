package com.example.gilin.dain;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gilin.R;
import com.example.gilin.databinding.FragmentFindPasswordBinding;
import com.example.gilin.databinding.FragmentPasswordResetBinding;

public class PasswordReset extends Fragment {

    private FragmentPasswordResetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPasswordResetBinding.inflate(inflater, container, false);

        binding.passwordResetBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new FindPassword());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.passwordResetButton.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new Login());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return binding.getRoot();
    }
}