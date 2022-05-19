package com.example.marowl.model;

import com.google.firebase.firestore.DocumentId;

public class ComicsModel {
    @DocumentId
    private String ComicsId;
    private String title;
    private String description;
    private String img_url;
    private String pdfUrl;

    public ComicsModel(String comicsId, String title, String description, String imgUrl, String pdfUrl) {
        ComicsId = comicsId;
        this.title = title;
        this.description = description;
        this.img_url = imgUrl;
        this.pdfUrl = pdfUrl;
    }

    public ComicsModel() {}

    public String getComicsId() {
        return ComicsId;
    }

    public void setComicsId(String comicsId) {
        ComicsId = comicsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
