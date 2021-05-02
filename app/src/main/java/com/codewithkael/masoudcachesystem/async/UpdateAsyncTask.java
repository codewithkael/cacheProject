package com.codewithkael.masoudcachesystem.async;

import android.os.AsyncTask;

import com.codewithkael.masoudcachesystem.ImageModel;
import com.codewithkael.masoudcachesystem.persistence.LocationDao;


public class UpdateAsyncTask extends AsyncTask<ImageModel,Void,Void> {

    LocationDao mDao;
    public UpdateAsyncTask(LocationDao dao) {
        mDao = dao;
    }

    @Override
    protected Void doInBackground(ImageModel... locations) {
        mDao.update(locations);
        return null;
    }
}
