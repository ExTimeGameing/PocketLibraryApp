package com.example.pocketlibrary.View;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;
import com.example.pocketlibrary.ViewModel.authViewModel;
import com.example.pocketlibrary.databinding.ActivitySignUpBinding;
import com.example.pocketlibrary.repos.userRepo;

import java.lang.annotation.Native;

public class SignUp extends Fragment {
    ActivitySignUpBinding binding;
    userRepo repo = new userRepo();
    authViewModel auth = new authViewModel();
    public SignUp(){}

    public static SignUp newInstance () {
        return new SignUp();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sign_up, container, false);
        binding = ActivitySignUpBinding.bind(view);
        final AlertDialog.Builder dialog2 = new AlertDialog.Builder(binding.getRoot().getContext())
                .setTitle("Вы чего?")
                .setMessage("Извините, кажется одно из полей осталось пустым")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        binding.ellipse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.etUserName2.getText().toString();
                String password = binding.etPassword2.getText().toString();
                String email = binding.etUserName3.getText().toString();
                Log.i("DEBUGTAG", repo.userSet.toString());
                if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    dialog2.show();
                } else {
                    if (!hasUser(name)) {
                        repo.addUser(name, email, password);
                        auth.setnUser(repo.getUserByName(name));
                        Navigation.findNavController(view).navigate(R.id.action_signUp_to_instruction);
                    } else {
                        final AlertDialog.Builder dialog = new AlertDialog.Builder(binding.getRoot().getContext())
                                .setTitle("Куда мы лезим?!")
                                .setMessage("Извините, но пользователь с таким именем уже существует.")
                                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                        dialog.show();
                    }
                }
            }
        });
        binding.rectangle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_signUp_to_logIn);
            }
        });
        return binding.getRoot();
    }
    public boolean hasUser(String name){
        return auth.haveUser(name);
    }
}