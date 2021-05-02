package com.codewithkael.masoudcachesystem;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoModel implements Parcelable {
    private String ID,name,video_address,category_name,thumbnail_address;

    public VideoModel() {
    }

    public VideoModel(String ID, String name, String video_address, String category_name, String thumbnail_address) {
        this.ID = ID;
        this.name = name;
        this.video_address = video_address;
        this.category_name = category_name;
        this.thumbnail_address = thumbnail_address;
    }

    protected VideoModel(Parcel in) {
        ID = in.readString();
        name = in.readString();
        video_address = in.readString();
        category_name = in.readString();
        thumbnail_address = in.readString();
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo_address() {
        return video_address;
    }

    public void setVideo_address(String video_address) {
        this.video_address = video_address;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getThumbnail_address() {
        return thumbnail_address;
    }

    public void setThumbnail_address(String thumbnail_address) {
        this.thumbnail_address = thumbnail_address;
    }

    @Override
    public String toString() {
        return "VideoModel{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", video_address='" + video_address + '\'' +
                ", category_name='" + category_name + '\'' +
                ", thumbnail_address='" + thumbnail_address + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ID);
        parcel.writeString(name);
        parcel.writeString(video_address);
        parcel.writeString(category_name);
        parcel.writeString(thumbnail_address);
    }
}
