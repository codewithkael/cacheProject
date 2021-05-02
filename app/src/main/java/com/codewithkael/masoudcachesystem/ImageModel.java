package com.codewithkael.masoudcachesystem;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "images")
public class ImageModel {


    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "image_id")
    private String image_id;

    @ColumnInfo (name = "image_url")
    private String image_url;

    @ColumnInfo(name = "downloaded")
    private Boolean downloaded=false;

    public Boolean getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        this.downloaded = downloaded;
    }

    @Ignore
    public ImageModel() {
    }

    public ImageModel(String image_id, String image_url,Boolean downloaded) {
        this.image_id = image_id;
        this.image_url = image_url;
        this.downloaded = downloaded;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "image_id='" + image_id + '\'' +
                ", image_url='" + image_url + '\'' +
                ", downloaded=" + downloaded +
                '}';
    }
}
