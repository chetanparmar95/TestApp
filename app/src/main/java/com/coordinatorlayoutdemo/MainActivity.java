package com.coordinatorlayoutdemo;

import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.coordinatorlayoutdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager supportFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        supportFm = getFragmentManager();
        FragmentHelper.getInstance().replaceFragment(supportFm, R.id.container_body, new HomeFragment(), getString(R.string.home), getString(R.string.home));


        binding.bottomNavigation.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentHelper.getInstance().replaceFragment(supportFm, R.id.container_body, new HomeFragment(), getString(R.string.home), getString(R.string.home));
            }
        });

        binding.bottomNavigation.userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentHelper.getInstance().replaceFragment(supportFm, R.id.container_body, new UserProfileFragment(), getString(R.string.user_profile), getString(R.string.user_profile));
            }
        });
    }
}
