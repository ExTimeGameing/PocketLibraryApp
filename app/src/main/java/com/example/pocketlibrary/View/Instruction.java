package com.example.pocketlibrary.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;
import com.example.pocketlibrary.databinding.ActivityInstructionBinding;

public class Instruction extends Fragment {
    ActivityInstructionBinding binding;
    public Instruction() {
        // Required empty public constructor
    }

    public static Instruction newInstance() {
        return new Instruction();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_instruction, container, false);
        binding = ActivityInstructionBinding.bind(view);
        binding.rectangle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_instruction_to_actualNews);
                MainActivity.navigation.setVisibility(View.VISIBLE);
            }
        });
        return binding.getRoot();
    }
}