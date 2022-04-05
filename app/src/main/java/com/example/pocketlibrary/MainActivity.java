package com.example.pocketlibrary;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.actualNews:
                    loadFragment(ActualNews.newInstance());
                    return true;
                case R.id.booksList:
                    loadFragment(BooksList.newInstance());
                    return true;
                case R.id.profile2:
                    loadFragment(profile.newInstance());
                    return true;
                case R.id.search:
                    loadFragment(search.newInstance());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavig);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (bool){
            loadFragment(book.newInstance());
            bool = false;
        }
    }
    Boolean bool = false;
    public void clickListener(View view){
        switch (view.getId()){
            case R.id.ants_book:{
                loadFragment(book.newInstance());
                break;
            }
            case R.id.buy:{
                bool = true;
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.rectangle_10:{
                loadFragment(reglament.newInstance());
                break;
            }
            case R.id.rectangle_11:{
                Intent intent = new Intent(this, LogIn.class);
                startActivity(intent);
                break;
            }
            case R.id.back_2:{
                loadFragment(profile.newInstance());
                break;
            }
            case R.id.back_1:{
                loadFragment(BooksList.newInstance());
                break;
            }
        }
    }
}
