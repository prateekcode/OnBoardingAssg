package co.riek.onboardingassg.ui;

import android.content.Intent;
import android.os.Bundle;

import co.riek.onboardingassg.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.appCompatTextView.setOnClickListener(view -> {
            startActivity(new Intent(this, OnBoardingActivity.class));
        });
    }
}