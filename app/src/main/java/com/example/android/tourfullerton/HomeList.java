package com.example.android.tourfullerton;


/**
 * Class that is used to fill in the data in the main page
 */
public class HomeList {

    private String title;
    private String titleDetail;
    private int imageResourceID;

    /**
     * Default constructor to hold the values to be displayed in the home screen
     */
    public HomeList(String title, String titleDetail, int imageResourceID) {
        this.title = title;
        this.imageResourceID = imageResourceID;
        this.titleDetail = titleDetail;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleDetail() {
        return titleDetail;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }
}
