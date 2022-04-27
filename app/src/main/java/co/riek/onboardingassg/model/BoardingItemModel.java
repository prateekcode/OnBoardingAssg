package co.riek.onboardingassg.model;

import android.graphics.drawable.Drawable;

public class BoardingItemModel {

    private Drawable boardingImage;
    private String boardingText;

    public BoardingItemModel(Drawable boardingImage, String boardingText) {
        this.boardingImage = boardingImage;
        this.boardingText = boardingText;
    }

    public Drawable getBoardingImage() {
        return boardingImage;
    }

    public void setBoardingImage(Drawable boardingImage) {
        this.boardingImage = boardingImage;
    }

    public String getBoardingText() {
        return boardingText;
    }

    public void setBoardingText(String boardingText) {
        this.boardingText = boardingText;
    }
}
