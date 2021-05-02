package com.codewithkael.masoudcachesystem;

import java.util.List;

public class MainVideosModel {

    private List<ImageModel> user_images;
    private Boolean firebase_problem;
    private List<CategoryModel> category;

    public MainVideosModel() {
    }

    public MainVideosModel(List<ImageModel> user_images, Boolean firebase_problem, List<CategoryModel> category) {
        this.user_images = user_images;
        this.firebase_problem = firebase_problem;
        this.category = category;
    }

    @Override
    public String toString() {
        return "MainVideosModel{" +
                "user_images=" + user_images +
                ", firebase_problem=" + firebase_problem +
                ", category=" + category +
                '}';
    }

    public List<ImageModel> getUser_images() {
        return user_images;
    }

    public void setUser_images(List<ImageModel> user_images) {
        this.user_images = user_images;
    }

    public Boolean getFirebase_problem() {
        return firebase_problem;
    }

    public void setFirebase_problem(Boolean firebase_problem) {
        this.firebase_problem = firebase_problem;
    }

    public List<CategoryModel> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryModel> category) {
        this.category = category;
    }
}
