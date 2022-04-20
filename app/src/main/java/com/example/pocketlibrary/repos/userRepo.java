package com.example.pocketlibrary.repos;

import com.example.pocketlibrary.Model.User;

public class userRepo {
    public static User [] userSet = new User[10];

    public userRepo(){
        userSet[0] = new User();
        userSet[0].setCode(1);
        userSet[0].setNickname("Егор");
        userSet[0].setPassword("111");
        userSet[0].setEmail("alister@mail.ru");
    }

}
