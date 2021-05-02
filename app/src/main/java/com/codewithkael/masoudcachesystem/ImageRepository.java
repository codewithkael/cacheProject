package com.codewithkael.masoudcachesystem;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.codewithkael.masoudcachesystem.persistence.LocationDao;
import com.codewithkael.masoudcachesystem.persistence.LocationDatabase;

import java.util.List;

public class ImageRepository {

    private LocationDao locationDao;

    private static ImageRepository instance;
    public static ImageRepository getInstance(Context context){
        if (instance==null){
            instance = new ImageRepository(context);
        }
            return instance;

    }

    private ImageRepository(Context context) {
        locationDao = LocationDatabase.getInstance(context).getLocationDao();
    }

    public LiveData<List<ImageModel>> geImageLists(){
        return locationDao.getImages();
    }

}
