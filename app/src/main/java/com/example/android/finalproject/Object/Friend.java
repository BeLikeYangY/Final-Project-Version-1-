package com.example.android.finalproject.Object;

/**
 * Created by Yang on 2017/5/1.
 */

public class Friend {
    private String name;
    private String imageId;
    private String uid;

    public Friend() {
    }

    public Friend(String name, String imageId, String uid) {
        this.name = name;
        this.imageId = imageId;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
