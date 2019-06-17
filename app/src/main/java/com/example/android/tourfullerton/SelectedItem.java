package com.example.android.tourfullerton;


/**
 * Class that is used to add information about the places of a title from the main page
 */
public class SelectedItem {

    //image id of the places
    private int imageResourceID;

    //name of the place
    private String itemTitle;

    //place's contact number
    private String itemPhoneNumber;

    //place's address
    private String itemAddress;

    //constructor to initialise the class fields
    public SelectedItem(int imageResourceID, String itemTitle, String itemPhoneNumber, String itemAddress) {
        this.imageResourceID = imageResourceID;
        this.itemTitle = itemTitle;
        this.itemPhoneNumber = itemPhoneNumber;
        this.itemAddress = itemAddress;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemPhoneNumber() {
        return itemPhoneNumber;
    }

    public String getItemAddress() {
        return itemAddress;
    }
}
