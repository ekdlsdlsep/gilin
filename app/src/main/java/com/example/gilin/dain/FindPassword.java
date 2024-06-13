package com.example.gilin.dain;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.databinding.FragmentFindPasswordBinding;

public class FindPassword extends Fragment {

    private FragmentFindPasswordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFindPasswordBinding.inflate(inflater, container, false);

        binding.findPasswordButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });

        binding.findPasswordBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new Login());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.findPasswordButton.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new PasswordReset());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.hideBottomNav();
        }
    }
}