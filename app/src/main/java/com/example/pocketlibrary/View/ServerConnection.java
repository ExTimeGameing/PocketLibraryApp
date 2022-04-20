package com.example.pocketlibrary.View;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;

import java.util.Timer;

public class ServerConnection extends Fragment {
    Timer timer;
    public ServerConnection(){}

    public static ServerConnection newInstance() {
        return new ServerConnection();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_server_connection, container, false);
    }
}