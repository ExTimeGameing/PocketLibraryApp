package com.example.pocketlibrary.ViewModel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.pocketlibrary.Model.User;
import com.example.pocketlibrary.repos.UserRepo;

public class AuthViewModel extends ViewModel {
    UserRepo repo = new UserRepo();
    static User nUser = new User();

    public AuthViewModel(){}

    public boolean authentication(String name, String password){
        User mUser = repo.getUserByName(name);
        if (mUser != null){
            Log.i("DEBUGTAG", mUser.getPassword() + "/" + password);
            if (mUser.getPassword().equals(password)){
                nUser = mUser;
                return true;
            }
        }
        return false;
    }

    public boolean haveUser(String name){
        User mUser = repo.getUserByName(name);
        return mUser != null;
    }

    public static User giveUser(){
        return nUser;
    }

    public void setnUser(User user){
        nUser = user;
    }
}
