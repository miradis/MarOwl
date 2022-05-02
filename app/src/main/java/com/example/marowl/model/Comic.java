package com.example.marowl.model;

public class Comic {
    private String comicName;
    private String description;
    private int image_URL;

    public Comic(String comicName, String description, int image_URL) {
        this.comicName = comicName;
        this.description = description;
        this.image_URL = image_URL;
    }

    public Comic() {
    }

    public String getComicName() {
        return comicName;
    }


    public String getDescription() {
        return description;
    }

    public int getImage_URL() {
        return image_URL;
    }
}
