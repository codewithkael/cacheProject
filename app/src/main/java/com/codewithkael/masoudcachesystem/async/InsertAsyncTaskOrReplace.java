package com.codewithkael.masoudcachesystem.async;

import android.os.AsyncTask;

import com.codewithkael.masoudcachesystem.ImageModel;
import com.codewithkael.masoudcachesystem.persistence.LocationDao;


public class InsertAsyncTaskOrReplace extends AsyncTask<ImageModel,Void, Long[]> {

    LocationDao mDao;
    public InsertAsyncTaskOrReplace(LocationDao dao) {
        mDao = dao;
    }

    @Override
    protected Long[] doInBackground(ImageModel... imageModels) {
        mDao.insertImage(imageModels);
        return mDao.insertImage();
    }
}
