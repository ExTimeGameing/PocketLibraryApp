package com.example.pocketlibrary.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;
import com.example.pocketlibrary.databinding.ActivityLogInBinding;
import com.example.pocketlibrary.repos.userRepo;

public class LogIn extends Fragment {
    ActivityLogInBinding binding;
    userRepo repo = new userRepo();

    public LogIn(){}

    public static LogIn newInstance() {
        return new LogIn();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_log_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = ActivityLogInBinding.bind(view);
    }

    @Override
    public void onDestroyView() {
        repo.userSet[0].setNickname(binding.etUserName1.getText().toString());
        repo.userSet[0].setPassword(binding.etPassword1.getText().toString());
        super.onDestroyView();
    }
}