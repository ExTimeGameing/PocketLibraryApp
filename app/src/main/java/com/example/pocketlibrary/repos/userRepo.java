package com.example.pocketlibrary.repos;

import android.os.Build;

import com.example.pocketlibrary.Model.User;

import java.util.ArrayList;
import java.util.List;

public class userRepo {
    public static List<User> userSet = new ArrayList<>();

    public userRepo(){
        User user = new User();
        user.setNickname("Wizzer");
        user.setEmail("bugrov102002@mail.ru");
        user.setPassword("1111");
        userSet.add(user);
    }

    public User getUserByID(String ID){
        User result = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = userSet.stream().filter(user -> user.getCode().equals(ID)).findFirst().get();
        }
        return result;
    }

}
