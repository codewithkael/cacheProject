package com.codewithkael.masoudcachesystem.async;

import android.os.AsyncTask;

import com.codewithkael.masoudcachesystem.ImageModel;
import com.codewithkael.masoudcachesystem.persistence.LocationDao;


public class DeleteAsyncTask extends AsyncTask<ImageModel,Void,Void> {

    LocationDao mDao;
    public DeleteAsyncTask(LocationDao dao) {
        mDao = dao;
    }

    @Override
    protected Void doInBackground(ImageModel... images) {
        mDao.delete(images);
        return null;
    }
}
