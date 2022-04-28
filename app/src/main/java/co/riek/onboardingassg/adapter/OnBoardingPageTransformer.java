package co.riek.onboardingassg.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import co.riek.onboardingassg.R;

public class OnBoardingPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);
        // The page is currently being scrolled / swiped
        View title = page.findViewById(R.id.tv_onboarding_onliner_text);
        title.setAlpha(1.0f - absPosition);
        title.setTranslationY(pageWidthTimesPosition / 2f);

        // Now, we want the image to move to the right,
        // i.e. in the opposite direction of the rest of the
        // content while fading out
        View onBoardingIv = page.findViewById(R.id.iv_onboarding_item);

        // We're attempting to create an effect for a View
        // specific to one of the pages in our ViewPager.
        // In other words, we need to check that we're on
        // the correct page and that the View in question
        // isn't null.
        if (onBoardingIv != null) {
            onBoardingIv.setAlpha(1.0f - absPosition);
            onBoardingIv.setTranslationX(-pageWidthTimesPosition * 1.5f);
            onBoardingIv.setTranslationY(-pageWidthTimesPosition / 2f);
        }

        View skipBtn = page.findViewById(R.id.btn_skip);
        skipBtn.setTranslationY(pageWidthTimesPosition/2f);

        View nextBtn = page.findViewById(R.id.btn_next);
        nextBtn.setTranslationY(pageWidthTimesPosition/2f);
    }
}
