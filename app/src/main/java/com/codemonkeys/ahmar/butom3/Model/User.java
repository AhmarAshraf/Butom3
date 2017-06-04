package com.codemonkeys.ahmar.butom3.Model;

/**
 * Created by Ahmar on 09/05/2017.
 */

public class User {
    private int imageResourceId;
    private String profileName;
    private String phoneNumber;
    private String emailId;

    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getProfileName() {
        return profileName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmailId() {
        return emailId;
    }

    public User(int imageResourceId, String profileName, String phoneNumber, String emailId) {
        this.imageResourceId = imageResourceId;
        this.profileName = profileName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }
}
