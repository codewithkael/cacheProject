package com.codewithkael.masoudcachesystem;




import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServisGenerator {
  private static Builder retrofitBuilder =
           new Builder().baseUrl(Constant.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create());

  private static Retrofit retrofit = retrofitBuilder.build();

  public static PuzzleApi speakaApi = retrofit.create(PuzzleApi.class);

    static PuzzleApi getRecipeApi(){

       return speakaApi;
   }

}
