package co.riek.onboardingassg.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import co.riek.onboardingassg.R;
import co.riek.onboardingassg.adapter.BoardingItemAdapter;
import co.riek.onboardingassg.databinding.ActivityOnboardingBinding;
import co.riek.onboardingassg.model.BoardingItemModel;

public class OnBoardingActivity extends AppCompatActivity {

    private ActivityOnboardingBinding binding;
    private final ArrayList<BoardingItemModel> boardingItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
        animateButton();
        makeStatusBarTransparent();
    }


    private void initUI() {
        BoardingItemModel item1 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.girl_social), "Simple popular app for the audience who loves memes");
        BoardingItemModel item2 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.boy_girl), "Subscribe any content that you like the most");
        BoardingItemModel item3 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.man_working), "Post your own content over there and see the reaction of people");
        boardingItemList.add(item1);
        boardingItemList.add(item2);
        boardingItemList.add(item3);
        BoardingItemAdapter boardingItemAdapter = new BoardingItemAdapter(boardingItemList);
        binding.rvBoardingItem.setAdapter(boardingItemAdapter);
        binding.rvBoardingItem.setLayoutManager(new LinearLayoutManager(this));
    }

    private void animateButton() {
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.bottom_up);
        binding.btnGetStarted.startAnimation(bottomUp);
        binding.btnGetStarted.setVisibility(View.VISIBLE);

        binding.btnGetStarted.setOnClickListener(view -> {
            startActivity(new Intent(OnBoardingActivity.this, HomeActivity.class));
            overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
        });
    }


    private void makeStatusBarTransparent() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}