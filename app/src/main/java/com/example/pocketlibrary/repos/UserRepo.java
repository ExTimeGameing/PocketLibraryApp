package com.example.pocketlibrary.repos;

import android.os.Build;
import com.example.pocketlibrary.Model.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    public List<User> userSet = new ArrayList<>();

    public UserRepo(){
        addUser("Wizzer", "bugrov102002@yandex.ru", "1111");
    }

    public void addUser(String name, String email, String password){
        User user = new User();
        user.setNickname(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setCode();
        userSet.add(user);
    }

    public User getUserByName(String name){
        User result = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                result = userSet.stream().filter(user -> user.getNickname().equals(name)).findFirst().get();
            } catch (Exception e){

            }
        }
        return result;
    }

}
