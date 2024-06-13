package com.example.gilin.dain;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gilin.MainActivity;
import com.example.gilin.R;
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.databinding.FragmentLoginBinding;

public class Login extends Fragment {

    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.hideBottomNav();
        }

        binding.loginId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.loginId.setBackgroundResource(R.drawable.login_round2);
                binding.loginError.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.loginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.loginPassword.setBackgroundResource(R.drawable.login_round2);
                binding.loginError.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // 메인으로 이동
        binding.loginButton.setOnClickListener(v -> {
            String userId = binding.loginId.getText().toString().trim();
            String password = binding.loginPassword.getText().toString().trim();

            boolean isValid = true;

            if (userId.isEmpty()) {
                binding.loginId.setBackgroundResource(R.drawable.error);
                binding.loginError.setText("*아이디를 입력해주세요.");
                isValid = false;
                return;
            } else {
                binding.loginId.setBackgroundResource(R.drawable.login_round2);
            }

            if (password.isEmpty()) {
                binding.loginPassword.setBackgroundResource(R.drawable.error);
                binding.loginError.setText("*비밀번호를 입력해주세요.");
                isValid = false;
                return;
            } else {
                binding.loginPassword.setBackgroundResource(R.drawable.login_round2);
            }

            if (isValid) {
                binding.loginError.setText("");

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

                PreferenceUtil.setUserId(getActivity(), userId);
                PreferenceUtil.setLoginStatus(getActivity(), "o");
            }
        });

        // 추후 추가
        binding.loginJoin.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new Join());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.loginFindPassword.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new FindPassword());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

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