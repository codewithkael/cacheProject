package com.codewithkael.masoudcachesystem.async;

import android.os.AsyncTask;
import android.widget.ImageView;

import com.codewithkael.masoudcachesystem.ImageModel;
import com.codewithkael.masoudcachesystem.persistence.LocationDao;


public class GetImageAsyncTask extends AsyncTask<String,Void,ImageModel> {

    LocationDao mDao;
    public GetImageAsyncTask(LocationDao dao) {
        mDao = dao;
    }

    @Override
    protected ImageModel doInBackground(String... strings) {

        return mDao.getImage(strings[0]);
    }
}
