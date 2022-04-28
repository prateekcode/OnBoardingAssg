package co.riek.onboardingassg.model;

import android.graphics.drawable.Drawable;

public class BoardingItemModel {

    private Drawable boardingImage;
    private String boardingText;
    private Drawable boardingBackgroundImage;
    private Drawable buttonBackground;

    public BoardingItemModel(Drawable boardingImage, String boardingText, Drawable boardingBackgroundImage) {
        this.boardingImage = boardingImage;
        this.boardingText = boardingText;
        this.boardingBackgroundImage = boardingBackgroundImage;
    }


    public BoardingItemModel(Drawable boardingImage, String boardingText) {
        this.boardingImage = boardingImage;
        this.boardingText = boardingText;
    }

    public BoardingItemModel(Drawable boardingImage, String boardingText, Drawable boardingBackgroundImage, Drawable buttonBackground) {
        this.boardingImage = boardingImage;
        this.boardingText = boardingText;
        this.boardingBackgroundImage = boardingBackgroundImage;
        this.buttonBackground = buttonBackground;
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

    public Drawable getBoardingBackgroundImage() {
        return boardingBackgroundImage;
    }

    public void setBoardingBackgroundImage(Drawable boardingBackgroundImage) {
        this.boardingBackgroundImage = boardingBackgroundImage;
    }

    public Drawable getButtonBackground() {
        return buttonBackground;
    }

    public void setButtonBackground(Drawable buttonBackground) {
        this.buttonBackground = buttonBackground;
    }
}
