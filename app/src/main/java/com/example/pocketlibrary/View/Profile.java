package com.example.pocketlibrary.View;

import static com.example.pocketlibrary.View.MainActivity.navCo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pocketlibrary.R;
import com.example.pocketlibrary.ViewModel.AuthViewModel;
import com.example.pocketlibrary.ViewModel.UserViewModel;
import com.example.pocketlibrary.databinding.FragmentProfileBinding;


public class Profile extends Fragment {
    UserViewModel model;
    FragmentProfileBinding binding;

    public Profile() {
    }

    public static Profile newInstance() {
        return new Profile();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(UserViewModel.class);
        model.setData(AuthViewModel.giveUser());
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentProfileBinding.bind(view);
        binding.rectangle11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ExTimeGameing/PocketLibraryApp"));
                startActivity(browserIntent);
            }
        });
        binding.rectangle10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCo.navigate(R.id.reglament);
            }
        });
        model.getmUser().observe(getViewLifecycleOwner(), user -> {
            binding.textProfile1.setText("Имя пользователя: " + user.getNickname());
            binding.textProfile2.setText("Почта: " + user.getEmail());
            binding.textProfile3.setText("Код читателя: " + user.getCode());
        });


    }

}