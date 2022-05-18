package com.example.pocketlibrary.View;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;

public class Book extends Fragment {

    public Book() {
        // Required empty public constructor
    }

    public static Book newInstance() {
        return new Book();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_book, container, false);
    }
}