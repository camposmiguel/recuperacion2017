package com.miguelcr.a02_recyclerview;

/**
 * Created by miguelcampos on 12/5/17.
 */

public class FootballPlayer {
    private String photoPath;
    private String name;
    private int age;

    public FootballPlayer(String photoPath, String name, int age) {
        this.photoPath = photoPath;
        this.name = name;
        this.age = age;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
