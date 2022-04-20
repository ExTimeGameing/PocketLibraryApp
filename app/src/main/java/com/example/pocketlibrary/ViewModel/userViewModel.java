package com.example.pocketlibrary.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.pocketlibrary.Model.User;
import com.example.pocketlibrary.repos.userRepo;

public class userViewModel extends ViewModel {
    private User mUser = new User();
    private userRepo repo = new userRepo();

    public void setData(){
        mUser = userRepo.userSet[0];
    }

    public String getName(){
        return "Имя пользователя: " + mUser.getNickname();
    }

    public String getPassword(){
        return mUser.getPassword();
    }

    public String getEmail(){
        return "Почта: " + mUser.getEmail();
    }

    public String getCode(){
        return "Код читателя: " + mUser.getCode();
    }
}
