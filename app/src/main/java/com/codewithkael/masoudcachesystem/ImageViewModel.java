package com.codewithkael.masoudcachesystem;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ImageViewModel  extends AndroidViewModel {

    private ImageRepository imageRepository;

    public ImageViewModel(@NonNull Application application) {
        super(application);
        imageRepository =ImageRepository.getInstance(application);
    }

    public LiveData<List<ImageModel>> getImages(){
        return imageRepository.geImageLists();

    }
}
