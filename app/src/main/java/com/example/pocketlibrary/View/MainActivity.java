package com.example.pocketlibrary.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.pocketlibrary.Model.User;
import com.example.pocketlibrary.R;
import com.example.pocketlibrary.databinding.ActivityLogInBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.TimeUnit;


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

    public void loadFragment(Fragment fragment) {
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
        navigation.setVisibility(View.GONE);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (bool){
            loadFragment(book.newInstance());
            bool = false;
        }
        loadFragment(SignUp.newInstance());
    }

    Boolean bool = false;
    public void clickListener(View view){
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavig);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
                loadFragment(LogIn.newInstance());
                navigation.setVisibility(View.GONE);
                break;
            }
            case R.id.rectangle_4:
            case R.id.send_btn: {
                loadFragment(LogIn.newInstance());
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
            case R.id.ellipse_5:{ ;
                loadFragment(Instruction.newInstance());
                break;
            }
            case R.id.ellipse_10: {

                break;
            }
            case R.id.rectangle_8: {
                loadFragment(ActualNews.newInstance());
                navigation.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.forgot:{
                loadFragment(ForgotPassword.newInstance());
                break;
            }
            case R.id.rectangle_5:{
                loadFragment(SignUp.newInstance());
                break;
            }
        }
    }
}
