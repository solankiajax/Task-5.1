package com.example.NewsApp;

public class News {
    private int id, image;
    private String smallDescription, BigDescription, newsSource;

    public News(int id, int image, String smallDescription, String bigDescription, String newsSource) {
        this.id = id;
        this.image = image;
        this.smallDescription = smallDescription;
        this.BigDescription = bigDescription;
        this.newsSource = newsSource;
    }

    public News(int id, int image, String smallDescription, String newsSource) {
        this.id = id;
        this.image = image;
        this.smallDescription = smallDescription;
        this.newsSource = newsSource;
    }

    public News(int id, int image) {
        this.id = id;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBigDescription() {
        return BigDescription;
    }

    public void setBigDescription(String bigDescription) {
        BigDescription = bigDescription;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }
}
