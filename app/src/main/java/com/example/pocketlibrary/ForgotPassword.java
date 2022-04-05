package com.example.pocketlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void sendClick(View view) {
        switch (view.getId()){
            case R.id.send_btn:{
                Intent intent = new Intent(this, LogIn.class);
                startActivity(intent);
                break;
            }
        }
    }
}