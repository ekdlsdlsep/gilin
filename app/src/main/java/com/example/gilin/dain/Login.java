package com.example.gilin.dain;

import android.content.Intent;
import android.os.Bundle;
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

    public Login() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.hideBottomNav();
        }

        // 메인으로 이동
        binding.loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);

            String userId = binding.loginId.getText().toString().trim();
            PreferenceUtil.setUserId(getActivity(), userId);
            PreferenceUtil.setLoginStatus(getActivity(), "o");
        });

        // 추후 추가
        binding.loginJoin.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new Join());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return binding.getRoot();

    }

    //

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