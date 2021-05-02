package com.codewithkael.masoudcachesystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.codewithkael.masoudcachesystem.adapter.RecyclerAdapter;
import com.codewithkael.masoudcachesystem.async.DeleteAllAsyncTask;
import com.codewithkael.masoudcachesystem.async.InsertAsyncTask;
import com.codewithkael.masoudcachesystem.async.InsertAsyncTaskOrReplace;
import com.codewithkael.masoudcachesystem.persistence.LocationDao;
import com.codewithkael.masoudcachesystem.persistence.LocationDatabase;
import com.codewithkael.masoudcachesystem.persistence.LocationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ImageViewModel imageViewModel;
    LocationDao locationDao;
    LocationRepository locationRepository;
    private List<ImageModel> imageModelsList =new ArrayList<>();
    ImageNetViewModel imageNetViewModel;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.mainRecycler);
        recyclerAdapter = new RecyclerAdapter(this,imageModelsList);


        locationDao = LocationDatabase.getInstance(this).getLocationDao();
        locationRepository = new LocationRepository(this);
        imageNetViewModel = ViewModelProviders.of(this).get(ImageNetViewModel.class);
//        new DeleteAllAsyncTask(locationDao).execute();
        imageViewModel = ViewModelProviders.of(this).get(ImageViewModel.class);


        imageViewModel.getImages().observe(this, new Observer<List<ImageModel>>() {
            @Override
            public void onChanged(List<ImageModel> imageModels) {
                Log.d(TAG, "mainMasoud from database : "+imageModels.toString());
                imageModelsList.clear();
                imageModelsList.addAll(imageModels);
                recyclerAdapter.notifyDataSetChanged();

            }
        });
        imageNetViewModel.searchInternet();

        imageNetViewModel.getImagesFromNet().observe(this, new Observer<List<ImageModel>>() {
            @Override
            public void onChanged(List<ImageModel> imageModels) {

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        for (ImageModel model : imageModels){


                            if (!locationDao.exists(model.getImage_id())){
                                locationDao.insertImages(model);
                            }

                        }
                    }
                });

            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }


}