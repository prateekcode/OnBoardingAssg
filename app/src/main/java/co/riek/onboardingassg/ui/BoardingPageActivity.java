package co.riek.onboardingassg.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.content.res.AppCompatResources;

import java.util.ArrayList;

import co.riek.onboardingassg.R;
import co.riek.onboardingassg.adapter.OnBoardingAdapter;
import co.riek.onboardingassg.adapter.OnBoardingPageTransformer;
import co.riek.onboardingassg.databinding.ActivityBoardingPageBinding;
import co.riek.onboardingassg.model.BoardingItemModel;

public class BoardingPageActivity extends BaseActivity {

    private ActivityBoardingPageBinding binding;
    private OnBoardingAdapter onBoardingAdapter;
    private final ArrayList<BoardingItemModel> boardingItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBoardingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAdapter();
    }

    private void initAdapter() {
        BoardingItemModel item1 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.girl_social), getString(R.string.boarding_msg_1), AppCompatResources.getDrawable(this, R.drawable.ic_background_img), AppCompatResources.getDrawable(this, R.drawable.btn_background));
        BoardingItemModel item2 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.boy_girl), getString(R.string.boarding_msg_2), AppCompatResources.getDrawable(this, R.drawable.ic_background_2), AppCompatResources.getDrawable(this, R.drawable.pink_btn_bkg));
        BoardingItemModel item3 = new BoardingItemModel(AppCompatResources.getDrawable(this, R.drawable.man_working), getString(R.string.boarding_msg_3), AppCompatResources.getDrawable(this, R.drawable.ic_background_3), AppCompatResources.getDrawable(this, R.drawable.green_btn_bkg));
        boardingItemList.add(item1);
        boardingItemList.add(item2);
        boardingItemList.add(item3);
        onBoardingAdapter = new OnBoardingAdapter(this, boardingItemList);
        binding.vpOnboardingSlider.setAdapter(onBoardingAdapter);
        binding.vpOnboardingSlider.setPageTransformer(false, new OnBoardingPageTransformer());
        onBoardingAdapter.notifyDataSetChanged();
    }

    public void skipButton(View view) {
        launchHomeActivity();
    }

    public void nextButton(View view) {
        if (view.getId() == R.id.btn_next) {
            if (binding.vpOnboardingSlider.getCurrentItem() < onBoardingAdapter.getCount() - 1) {
                binding.vpOnboardingSlider.setCurrentItem(binding.vpOnboardingSlider.getCurrentItem() + 1, true);
            }else {
                launchHomeActivity();
            }
        }
    }


    private void launchHomeActivity(){
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

}