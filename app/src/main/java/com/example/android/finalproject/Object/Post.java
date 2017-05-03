package com.example.android.finalproject.Object;

import java.io.Serializable;

/**
 * Created by Yang on 2017/4/30.
 */

public class Post implements Serializable {
    private String time;
    private double latitude;
    private double longitude;
    private String place;
    private String body;
    private String file;

    public Post(){

    };

    public Post(String time, double latitude, double longitude, String place, String body, String file) {
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.place = place;
        this.body = body;
        this.file = file;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


}