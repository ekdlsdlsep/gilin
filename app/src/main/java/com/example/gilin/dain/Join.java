package com.example.gilin.dain;

import android.content.Intent;
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
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.databinding.FragmentJoinBinding;

public class Join extends Fragment {

    private FragmentJoinBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJoinBinding.inflate(inflater, container, false);

        binding.joinPasswordButton.setOnClickListener(v -> {
            String name = binding.joinName.getText().toString().trim();
            String userId = binding.joinId.getText().toString().trim();
            String authentication = binding.joinAuthentication.getText().toString().trim();
            String password = binding.joinPassword.getText().toString().trim();
            String passwordCheck = binding.joinPasswordCheck.getText().toString().trim();

            // 이후 추가...
            if (name.isEmpty()) {
                binding.joinNameError.setText("*이름을 입력해주세요.");
            } else if (userId.isEmpty()) {
                binding.joinIdError.setText("*아이디를 입력해주세요.");
            } else {
                binding.joinNameError.setText("");
                binding.joinIdError.setText("");

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contentView, new Login());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        binding.joinBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new Login());
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