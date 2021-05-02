package com.codewithkael.masoudcachesystem;

import java.util.List;

public class CategoryModel {

    private String name,id;
    private List<VideoModel> videos;

    public CategoryModel() {
    }

    public CategoryModel(String name, String id, List<VideoModel> videos) {
        this.name = name;
        this.id = id;
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", videos=" + videos +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<VideoModel> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoModel> videos) {
        this.videos = videos;
    }
}
