package com.example.pocketlibrary.ViewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.pocketlibrary.Model.User;
import com.example.pocketlibrary.repos.UserRepo;
public class UserViewModel extends ViewModel {
    private MutableLiveData<User> mUser = new MutableLiveData<>();
    private UserRepo repo;

    public void setData(User user){
        mUser.setValue(user);
    }

    public MutableLiveData<User> getmUser() {
        return mUser;
    }
}
