package com.example.findjobs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.findjobs.BottomNavbar.AccountFragment;
import com.example.findjobs.BottomNavbar.CompaniesFragment;
import com.example.findjobs.BottomNavbar.JobsFragment;
import com.example.findjobs.BottomNavbar.MenuFragment;
import com.example.findjobs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new JobsFragment());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            CharSequence title = menuItem.getTitle();
            if ("Account".equals(title)) {
                replaceFragment(new AccountFragment());
            } else if ("Jobs".equals(title)) {
                replaceFragment(new JobsFragment());
            } else if ("Companies".equals(title)) {
                replaceFragment(new CompaniesFragment());
            }
            else if ("Menu".equals(title)) {
                replaceFragment(new MenuFragment());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}