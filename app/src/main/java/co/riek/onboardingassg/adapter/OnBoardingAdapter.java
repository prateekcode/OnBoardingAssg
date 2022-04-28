package co.riek.onboardingassg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import co.riek.onboardingassg.R;
import co.riek.onboardingassg.model.BoardingItemModel;

public class OnBoardingAdapter extends PagerAdapter {

    private final Context context;
    private final ArrayList<BoardingItemModel> boardingItems;

    public OnBoardingAdapter(Context context, ArrayList<BoardingItemModel> boardingItems) {
        this.context = context;
        this.boardingItems = boardingItems;
    }


    @Override
    public int getCount() {
        return boardingItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_onboarding_screen, container, false);

        ConstraintLayout layoutOnBoarding = view.findViewById(R.id.layout_onboarding);
        layoutOnBoarding.setBackground(boardingItems.get(position).getBoardingBackgroundImage());

        ShapeableImageView onBoardingItemImage = view.findViewById(R.id.iv_onboarding_item);
        onBoardingItemImage.setImageDrawable(boardingItems.get(position).getBoardingImage());

        AppCompatTextView onBoardingOneLinerText = view.findViewById(R.id.tv_onboarding_onliner_text);
        onBoardingOneLinerText.setText(boardingItems.get(position).getBoardingText());

        AppCompatButton nextButton = view.findViewById(R.id.btn_next);
        nextButton.setBackground(boardingItems.get(position).getButtonBackground());

        if (position == boardingItems.size()-1) {
            nextButton.setText(context.getString(R.string.get_started));
        }
        view.setTag(view);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
