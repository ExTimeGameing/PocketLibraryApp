package com.example.pocketlibrary.View;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pocketlibrary.R;
import com.example.pocketlibrary.ViewModel.authViewModel;
import com.example.pocketlibrary.databinding.ActivityLogInBinding;


public class LogIn extends Fragment {
    private static authViewModel auth = new authViewModel();
    private static ActivityLogInBinding binding;

    public LogIn(){}

    public static LogIn newInstance() {
        return new LogIn();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_log_in, container, false);
        binding = ActivityLogInBinding.bind(view);
        binding.ellipse10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOkay()){
                    Navigation.findNavController(view).navigate(R.id.action_logIn_to_actualNews);
                    MainActivity.navigation.setVisibility(View.VISIBLE);
                }
                else{
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(binding.getRoot().getContext())
                            .setTitle("ОШИБКА!")
                            .setMessage("Вы ввели неверное имя пользователя или пароль!")
                            .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                    dialog.show();
                }
            }
        });
        binding.rectangle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_logIn_to_signUp);
            }
        });
        binding.forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_logIn_to_forgotPassword);
            }
        });
        return binding.getRoot();
    }

    public boolean isOkay(){
        return auth.authentication(binding.etUserName1.getText().toString(),
                                    binding.etPassword1.getText().toString());
    }

}