package com.example.gilin.hyelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.gilin.R;
import com.example.gilin.dain.Login;
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.databinding.FragmentGaejungByeBinding;

public class gaejung_bye extends Fragment {

    private FragmentGaejungByeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGaejungByeBinding.inflate(inflater, container, false);

        CheckBox agreementCheckbox = binding.getRoot().findViewById(R.id.agreement_checkbox);
        Button gaejungByeButtonYes = binding.getRoot().findViewById(R.id.gaejungbye_button_yes);

        agreementCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gaejungByeButtonYes.setEnabled(isChecked);
            }
        });

        binding.gaejungByeBack.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new sulzzung());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.gaejungbyeButtonYes.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new Login());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            PreferenceUtil.setLoginStatus(getActivity(), "x");
        });

        binding.gaejungbyeButtonNo.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.contentView, new sulzzung());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return binding.getRoot();
    }
}