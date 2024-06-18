package com.example.gilin.hani;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.gilin.R;
import com.example.gilin.databinding.FragmentMypageDialogBinding;

public class MypageDialog extends DialogFragment {

    private FragmentMypageDialogBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMypageDialogBinding.inflate(inflater, container, false);

        binding.mypageDialog.setImageResource(R.drawable.ic_launcher_foreground);

        binding.mypageChangeButton.setOnClickListener(v -> {
            String newName = binding.editTextName.getText().toString();

            // mypage 프래그먼트로 이름 전달
            Bundle result = new Bundle();
            result.putString("newName", newName);
            getParentFragmentManager().setFragmentResult("requestKey", result);

            dismiss();
        });

        return binding.getRoot();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        return dialog;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
