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

public class OnBoardingActivity extends BaseActivity {

    private ActivityOnboardingBinding binding;
    private final ArrayList<BoardingItemModel> boardingItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
        animateButton();
    }


    private void initUI() {
        BoardingItemModel item1 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.girl_social), getString(R.string.boarding_msg_1));
        BoardingItemModel item2 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.boy_girl), getString(R.string.boarding_msg_2));
        BoardingItemModel item3 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.man_working), getString(R.string.boarding_msg_3));
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

}