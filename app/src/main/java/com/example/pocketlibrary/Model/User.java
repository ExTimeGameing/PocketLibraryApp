package com.example.pocketlibrary.Model;

public class User {
    protected String nickname;
    protected String email;
    protected String code;
    protected String password;

    public User() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static void loginUser(User user, String name, String password, String email, String code){
        user.setNickname(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setCode(code);
    }
}
