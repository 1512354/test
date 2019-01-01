package com.example.lenovo.smarttravel;

import java.io.Serializable;

public class ImageModel implements Serializable {
    private long id;
    private String imageName;
    private int imagePath;

    public ImageModel() {
    }

    public ImageModel(long id, String imageName, int imagePath) {
        this.id = id;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

}
