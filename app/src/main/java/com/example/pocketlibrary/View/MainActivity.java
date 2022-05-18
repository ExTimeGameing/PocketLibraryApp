package com.example.pocketlibrary.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.example.pocketlibrary.R;
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
                    loadFragment(Profile.newInstance());
                    return true;
                case R.id.search:
                    loadFragment(Search.newInstance());
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }

   static BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.bottomNavig);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setVisibility(View.GONE);
    }


    public void clickListener(View view){
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavig);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        switch (view.getId()){
            case R.id.ants_book:{
                loadFragment(Book.newInstance());
                break;
            }
            case R.id.buy:{
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.rectangle_10:{
                loadFragment(Reglament.newInstance());
                break;
            }
            case R.id.rectangle_11:{
                loadFragment(LogIn.newInstance());
                navigation.setVisibility(View.GONE);
                break;
            }
            case R.id.back_2:{
                loadFragment(Profile.newInstance());
                break;
            }
            case R.id.back_1:{
                loadFragment(BooksList.newInstance());
                break;
            }
        }
    }
}
