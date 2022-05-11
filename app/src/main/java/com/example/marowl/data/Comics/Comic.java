package com.example.marowl.data.Comics;

public class Comic {
    private String ComicTitle;
    private Integer ComicImage;
    private String ComicDetails;


    public Comic(String comicTitle, Integer comicImage, String comicDetails) {
        ComicTitle = comicTitle;
        ComicImage = comicImage;
        ComicDetails = comicDetails;
    }

    public String getComicTitle() {
        return ComicTitle;
    }

    public Integer getComicImage() {
        return ComicImage;
    }

    public String getComicDetails() {
        return ComicDetails;
    }
}
