package com.verity.datlashiv.acquaint.ModelClasses;

public class MainCourse {
    String name;
    String image;

    public MainCourse() {
    }

    public MainCourse(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
