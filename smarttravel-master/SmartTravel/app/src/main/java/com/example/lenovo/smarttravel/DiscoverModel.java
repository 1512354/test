package com.example.lenovo.smarttravel;

public class DiscoverModel {
    private int id;
    private String Title;
    private int Thumbnail ;

    public DiscoverModel(int id, String title, int thumbnail) {
        this.id = id;
        Title = title;
        Thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }



    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
