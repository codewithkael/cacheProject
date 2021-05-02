package com.codewithkael.masoudcachesystem;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ImageNetRepository {

    Requests requests;

    private static ImageNetRepository instance;
    public static ImageNetRepository getInstance(){
        if (instance == null){
            instance = new ImageNetRepository();
        }
        return instance;
    }

    private ImageNetRepository (){
        requests = new Requests();
    }


    public MutableLiveData<List<ImageModel>> getImagesFromNet(){
        return requests.getImagesFromNet();
    }

    public void searchNetImages(){
        requests.searchNetImage();
    }
}
