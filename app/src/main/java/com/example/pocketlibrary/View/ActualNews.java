package com.example.pocketlibrary.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;

public class ActualNews extends Fragment {

    public ActualNews() {
        // Required empty public constructor
    }

    public static ActualNews newInstance() {
        return new ActualNews();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actual_news, container, false);
    }
}