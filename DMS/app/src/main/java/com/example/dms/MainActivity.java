package com.example.dms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.dms.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private Notice fragmentNotice;
    private Application fragmentApplication;
    private Cafeteria fragmentCafeteria;
    private Mypage fragmentMypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        fragmentManager = getSupportFragmentManager();

        Fragment fragmentNotice = new Notice();
        Fragment fragmentApplication = new Application();
        Fragment fragmentCafeteria = new Cafeteria();
        Fragment fragmentMypage = new Mypage();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                int id = item.getItemId();

                switch (id){
                    case R.id.ap:
                        transaction.replace(R.id.frame_layout,fragmentApplication).commitAllowingStateLoss();
                        break;
                    case R.id.ca:
                        transaction.replace(R.id.frame_layout,fragmentCafeteria).commitAllowingStateLoss();
                        break;
                    case R.id.my:
                        transaction.replace(R.id.frame_layout,fragmentMypage).commitAllowingStateLoss();
                        break;
                    case R.id.no:
                        transaction.replace(R.id.frame_layout,fragmentNotice).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });

    }
}