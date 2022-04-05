package com.example.pocketlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void loginClick(View view) {
        switch (view.getId()){
            case R.id.ellipse_10:{
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.forgot:{
                Intent intent = new Intent(this, ForgotPassword.class);
                startActivity(intent);
                break;
            }
            case R.id.rectangle_5:{
                Intent intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;
            }
        }
    }
}