package com.example.pocketlibrary.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pocketlibrary.R;
import com.example.pocketlibrary.ViewModel.userViewModel;
import com.example.pocketlibrary.databinding.FragmentProfileBinding;


public class profile extends Fragment {
    userViewModel model;
    FragmentProfileBinding binding;

    public profile() {
    }

    public static profile newInstance() {
        return new profile();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(userViewModel.class);
        model.setData();
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentProfileBinding.bind(view);

        model.getmUser().observe(getViewLifecycleOwner(), user -> {
            binding.textProfile1.setText("Имя пользователя: " + user.getNickname());
            binding.textProfile2.setText("Почта: " + user.getEmail());
            binding.textProfile3.setText("Код читателя: " + user.getCode());
        });


    }

}