package com.example.pocketlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signupClick(View view) {
        switch (view.getId()){
            case R.id.rectangle_4:{
                Intent intent = new Intent(this, LogIn.class);
                startActivity(intent);
                break;
            }
            case R.id.ellipse_5:{
                Intent intent = new Intent(this, Instruction.class);
                startActivity(intent);
                break;
            }
        }
    }
}