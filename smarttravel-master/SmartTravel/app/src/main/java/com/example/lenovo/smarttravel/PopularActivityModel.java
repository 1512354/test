package com.example.lenovo.smarttravel;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PopularActivityModel  implements Parcelable {

    private long id;
    private String Title;
    private int imagePath;
    private String Price;
    private String Review;
    private String Destination;

    public PopularActivityModel(long id, String title, int imagePath, String price, String review, String destination) {
        this.id = id;
        Title = title;
        this.imagePath = imagePath;
        Price = price;
        Review = review;
        Destination = destination;
    }

    public PopularActivityModel() {
    }



    protected PopularActivityModel(Parcel in) {
        id = in.readLong();
        Title = in.readString();
        imagePath = in.readInt();
        Price = in.readString();
        Review = in.readString();
        Destination = in.readString();
    }

    public static final Creator<PopularActivityModel> CREATOR = new Creator<PopularActivityModel>() {
        @Override
        public PopularActivityModel createFromParcel(Parcel in) {
            return new PopularActivityModel(in);
        }

        @Override
        public PopularActivityModel[] newArray(int size) {
            return new PopularActivityModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(Title);
        parcel.writeInt(imagePath);
        parcel.writeString(Price);
        parcel.writeString(Review);
        parcel.writeString(Destination);
    }
}
