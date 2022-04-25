package com.example.pocketlibrary.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pocketlibrary.Model.User;
import com.example.pocketlibrary.repos.userRepo;

public class userViewModel extends ViewModel {
    private MutableLiveData<User> mUser = new MutableLiveData<>();
    private userRepo repo;

    public MutableLiveData<User> getmUser() {
        return mUser;
    }
}
