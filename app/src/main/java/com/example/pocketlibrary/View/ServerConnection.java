package com.example.pocketlibrary.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;
import com.example.pocketlibrary.databinding.ActivityServerConnectionBinding;

import java.util.Timer;

public class ServerConnection extends Fragment {
    ActivityServerConnectionBinding binding;
    public ServerConnection(){}

    public static ServerConnection newInstance() {
        return new ServerConnection();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.activity_server_connection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = ActivityServerConnectionBinding.bind(view);
        Navigation.findNavController(view).navigate(R.id.action_serverConnection_to_logIn);

    }
}