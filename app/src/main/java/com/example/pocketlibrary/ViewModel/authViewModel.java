package com.example.pocketlibrary.ViewModel;

import com.example.pocketlibrary.Model.User;

public class authViewModel {

    public static void registrate(User user, String name, String password, String email, String code){
        user.setNickname(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setCode(code);
    }
}
