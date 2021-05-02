package com.codewithkael.masoudcachesystem;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ImageNetViewModel extends AndroidViewModel {

    private ImageNetRepository imageNetRepository;

    public ImageNetViewModel(@NonNull Application application) {
        super(application);
        imageNetRepository = ImageNetRepository.getInstance();

    }

    public void searchInternet(){
        imageNetRepository.searchNetImages();
    }

    public MutableLiveData<List<ImageModel>> getImagesFromNet(){
        return imageNetRepository.getImagesFromNet();
    }
}
