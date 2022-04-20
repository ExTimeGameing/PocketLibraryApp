package com.example.pocketlibrary.View;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;

public class ForgotPassword extends Fragment {

    public ForgotPassword() {
        // Required empty public constructor
    }

    public static ForgotPassword newInstance() {
        return new ForgotPassword();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_forgot_password, container, false);
    }
}