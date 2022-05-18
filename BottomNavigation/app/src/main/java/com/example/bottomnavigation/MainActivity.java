package com.example.bottomnavigation;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private FragmentBi fragmentBi;
    private fragment_ne fragmentNe;
    private fragment_it fragmentIt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        Fragment fragmentBi = new FragmentBi();
        Fragment fragmentNe = new fragment_ne();
        Fragment fragmentIt = new fragment_it();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int id = item.getItemId();

                switch (id) {
                    case R.id.i1:
                        transaction.replace(R.id.frame_layout, fragmentBi).commitAllowingStateLoss();
                        break;
                    case R.id.i2:
                        transaction.replace(R.id.frame_layout, fragmentNe).commitAllowingStateLoss();
                        break;
                    case R.id.i3:
                        transaction.replace(R.id.frame_layout, fragmentIt).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }
}