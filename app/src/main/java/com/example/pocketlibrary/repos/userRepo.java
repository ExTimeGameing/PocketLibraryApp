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
        user.setCode();
        addUser(user);
    }

    public void addUser(User user){
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
