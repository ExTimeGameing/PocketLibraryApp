package com.example.pocketlibrary.View;

import static com.example.pocketlibrary.View.MainActivity.navCo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;
import com.example.pocketlibrary.databinding.ActivityStatusBinding;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Status extends Fragment {

public Status(){
}
    ActivityStatusBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_status, container, false);
        binding = ActivityStatusBinding.bind(view);
        Locale local = new Locale("ru","Ru");
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,DateFormat.DEFAULT,local);
        Date currentDate = new Date();
        String strD = df.format(currentDate);
        binding.rectangle13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCo.navigate(R.id.booksList);
                MainActivity.navigation.setVisibility(View.VISIBLE);
            }
        });
        binding.statusText1.setText(strD);
        return binding.getRoot();
    }
}