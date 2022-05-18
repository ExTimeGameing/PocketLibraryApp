package com.example.pocketlibrary.View;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.Model.User;
import com.example.pocketlibrary.R;
import com.example.pocketlibrary.databinding.ActivityForgotPasswordBinding;
import com.example.pocketlibrary.repos.userRepo;

public class ForgotPassword extends Fragment {
    ActivityForgotPasswordBinding binding;
    userRepo repo = new userRepo();

    public ForgotPassword() {
        // Required empty public constructor
    }

    public static ForgotPassword newInstance() {
        return new ForgotPassword();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_forgot_password, container, false);
        binding = ActivityForgotPasswordBinding.bind(view);
        binding.backFp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_forgotPassword_to_logIn);
            }
        });
        binding.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.etUsername.getText().toString();
                if (!name.isEmpty()){
                    User user = repo.getUserByName(name);
                    if (user != null){
                        final AlertDialog.Builder dialog = new AlertDialog.Builder(binding.getRoot().getContext())
                                .setTitle("Письмо отправлено!")
                                .setMessage("Мы отправли письмо со сбросом пароля Вам на почту")
                                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                        Navigation.findNavController(view).navigate(R.id.action_forgotPassword_to_logIn);
                                    }
                                });
                        dialog.show();
                    } else{
                        final AlertDialog.Builder dialog = new AlertDialog.Builder(binding.getRoot().getContext())
                                .setTitle("Ошибка!")
                                .setMessage("Вы ввели неверное имя пользователя")
                                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                        dialog.show();
                    }
                } else{
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(binding.getRoot().getContext())
                            .setTitle("Ошибка!")
                            .setMessage("Вы не заполнили имя пользователя")
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
        return binding.getRoot();
    }
}