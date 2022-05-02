package com.example.marowl.model;

public class comics {

    private String title;
    private String publicationDate;
    private String lastModifiedDate;
    private String pageCount;
    private String URL;
    private String image_URL;
    private String creator;
    private int list_id;
    private int hero_id;

    public comics(){}

    public comics(String title, String publicationDate, String lastModifiedDate, String pageCount, String URL, String image_URL, String creator, int list_id, int hero_id) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.pageCount = pageCount;
        this.URL = URL;
        this.image_URL = image_URL;
        this.creator = creator;
        this.list_id = list_id;
        this.hero_id = hero_id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getURL() {
        return URL;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public String getCreator() {
        return creator;
    }

    public int getList_id() {
        return list_id;
    }

    public int getHero_id() {
        return hero_id;
    }
}
