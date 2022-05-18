package com.example.pocketlibrary.View;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.pocketlibrary.Model.BookModel;
import com.example.pocketlibrary.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.common.eventbus.Subscribe;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.jar.Attributes;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.actualNews:
                    navCo.navigate(R.id.actualNews);
                    return true;
                case R.id.booksList:
                    navCo.navigate(R.id.booksList);
                    return true;
                case R.id.profile2:
                    navCo.navigate(R.id.profile2);
                    return true;
                case R.id.search:
                    navCo.navigate(R.id.search);
                    return true;
            }
            return false;
        }
    };

   static BottomNavigationView navigation;
    static NavHostFragment navHostFragment;
    public static NavController navCo;
    public static BookModel mBookModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.bottomNavig);
        navigation.setVisibility(View.GONE);
        navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);
        navCo = navHostFragment.getNavController();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }
}
