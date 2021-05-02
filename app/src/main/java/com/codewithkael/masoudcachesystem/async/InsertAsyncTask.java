package com.codewithkael.masoudcachesystem.async;

import android.os.AsyncTask;

import com.codewithkael.masoudcachesystem.ImageModel;
import com.codewithkael.masoudcachesystem.persistence.LocationDao;


public class InsertAsyncTask extends AsyncTask<ImageModel,Void,Void> {

    LocationDao mDao;
    public InsertAsyncTask(LocationDao dao) {
        mDao = dao;
    }

    @Override
    protected Void doInBackground(ImageModel... imageModels) {
        mDao.insertImages(imageModels);
        return null;
    }
}
