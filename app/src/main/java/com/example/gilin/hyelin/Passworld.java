package com.example.gilin.hyelin;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.databinding.FragmentPassworldBinding;

public class Passworld extends Fragment {

    private FragmentPassworldBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPassworldBinding.inflate(inflater, container, false);

        binding.changePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.passwordError.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.rePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.passwordError.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.passwordBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new sulzzung());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.passwordButtonYes.setOnClickListener(v -> {

            String password = binding.changePassword.getText().toString().trim();
            String rePassword = binding.rePassword.getText().toString().trim();

            boolean isValid = true;

            if (password.isEmpty()) {
                binding.passwordError.setText("*새로운 비밀번호를 입력해주세요.");
                isValid = false;
                return;
            }

            if (rePassword.isEmpty()) {
                binding.passwordError.setText("*비밀번호를 재입력해주세요.");
                isValid = false;
                return;
            }

            if (!password.equals(rePassword)) {
                binding.passwordError.setText("*재입력한 비밀번호가 새로운 비밀번호와 일치하지 않습니다.");
                isValid = false;
                return;
            }

            if (isValid) {
                binding.passwordError.setText("");

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contentView, new sulzzung());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return binding.getRoot();
    }
}