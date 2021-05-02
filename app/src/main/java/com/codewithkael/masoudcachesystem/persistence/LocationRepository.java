package com.codewithkael.masoudcachesystem.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.codewithkael.masoudcachesystem.ImageModel;
import com.codewithkael.masoudcachesystem.async.DeleteAsyncTask;
import com.codewithkael.masoudcachesystem.async.GetImageAsyncTask;
import com.codewithkael.masoudcachesystem.async.InsertAsyncTask;
import com.codewithkael.masoudcachesystem.async.UpdateAsyncTask;


import java.util.List;

public class LocationRepository {


    private LocationDatabase mLocationDatabase;

    public LocationRepository(Context context) {
        mLocationDatabase = LocationDatabase.getInstance(context);

    }

    public void insertLocation(ImageModel location){
        new InsertAsyncTask(mLocationDatabase.getLocationDao()).execute(location);
    }

    public void updateLocation(ImageModel location){
        new UpdateAsyncTask(mLocationDatabase.getLocationDao()).execute(location);
    }

    public LiveData<List<ImageModel>> retrieveLocations (){

        return mLocationDatabase.getLocationDao().getImages();
    }

    public void deleteLocation(ImageModel location){
        new DeleteAsyncTask(mLocationDatabase.getLocationDao()).execute(location);
    }

    public ImageModel getSingleImage(String imageId){
        return  mLocationDatabase.getLocationDao().getImage(imageId);
    }

}
