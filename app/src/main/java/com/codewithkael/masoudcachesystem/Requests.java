package com.codewithkael.masoudcachesystem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Requests {

    private MutableLiveData<List<ImageModel>> imageModels = new MutableLiveData<>();

    public MutableLiveData<List<ImageModel>> getImagesFromNet(){
        return imageModels;
    }

    public Requests() {


    }


    public void searchNetImage() {
        Call<MainVideosModel> videosModelCall = ServisGenerator.getRecipeApi()
                .getMainVideos("19340-HEFCSH9N9Q92H1L03PX0CIJQLRZX2OXFAFDAREGG",0);
        videosModelCall.enqueue(new Callback<MainVideosModel>() {
            @Override
            public void onResponse(Call<MainVideosModel> call, Response<MainVideosModel> response) {
                imageModels.postValue(response.body().getUser_images());
            }

            @Override
            public void onFailure(Call<MainVideosModel> call, Throwable t) {

            }
        });

    }
}
