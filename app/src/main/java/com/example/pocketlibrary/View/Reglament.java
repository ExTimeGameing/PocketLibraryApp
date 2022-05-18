package com.example.pocketlibrary.View;

import static com.example.pocketlibrary.View.MainActivity.navCo;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;
import com.example.pocketlibrary.databinding.ActivityReglamentBinding;

public class Reglament extends Fragment {
    ActivityReglamentBinding binding;

    public Reglament() {
        // Required empty public constructor
    }

    public static Reglament newInstance() {
        return new Reglament();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_reglament, container, false);
        binding = ActivityReglamentBinding.bind(view);
        binding.back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCo.navigate(R.id.profile2);
            }
        });
        return binding.getRoot();
    }
}