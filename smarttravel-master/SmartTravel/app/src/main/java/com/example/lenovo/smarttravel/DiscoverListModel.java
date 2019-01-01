package com.example.lenovo.smarttravel;

public class DiscoverListModel {
    private int id;
    private String Title;
    private String Subtitle;
    private int Thumbnail ;
    private String PlaceDay;

    public DiscoverListModel(int id, String title, String subtitle, int thumbnail, String placeDay) {
        this.id = id;
        Title = title;
        Subtitle = subtitle;
        Thumbnail = thumbnail;
        PlaceDay = placeDay;
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

    public String getSubtitle() {
        return Subtitle;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getPlaceDay() {
        return PlaceDay;
    }

    public void setPlaceDay(String placeDay) {
        PlaceDay = placeDay;
    }
}
