package com.codewithkael.masoudcachesystem;




import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface PuzzleApi {


//    @FormUrlEncoded
//    @POST("API/Users/Register")
//    Call<RegisterResponse> register (
//            @Field("firebase_id") String firebaseId,
//            @Field("mobile_number") String mobileNumber,
//            @Field("country_id") String country_id
//    );
//
//    @FormUrlEncoded
//    @POST("API/Users/Verify")
//    Call<ApiKeyResponse> verifyUser (
//            @Field("user_id") String user_id,
//            @Field("verification_code") String verificationCode
//    );
//
//
//    @GET("API/Users/users_update_firebase_id")
//    Call<Boolean> updateFirebaseId (
//            @Query("api_key")String api_key,
//            @Query("firebase_id") String firebase_id
//    );
//
    @GET("API/Users/users_get_videos")
    Call<MainVideosModel> getMainVideos(
            @Query("api_key")String api_key,
            @Query("Category_id") Integer category
    );
//
//    @GET("API/Users/users_submit_tasks")
//    Call<SubmitTaskModel> submitTask(
//            @Query("api_key") String api_key,
//            @Query("video_id") String videoId,
//            @Query("image_id") String image_id
//    );
//
//    @GET("API/Users/users_get_task")
//    Call<TaskModel> getTask (
//            @Query("api_key") String api_key,
//            @Query("task_id") String task_id
//
//    );
//
//    @Multipart
//    @POST("API/Users/users_upload_image")
//    Call<UploadImageModel> uploadImage(
//            @Part MultipartBody.Part image,
//            @Query("api_key") String api_key
//    );
//
//    @GET("API/Users/users_get_system_messages")
//    Call<SystemInfoModel> getInfoes(
//            @Query("api_key") String api_key
//    );
//
//    @GET("API/Users/users_get_system_messages_by_country")
//    Call<SystemInfoModel> getInfoesByCountryId(
//            @Query("country_id") String country_id
//    );
//
//
//    @GET("API/Users/users_cancel_task")
//    Call<CancelTaskResponse> cancelTask(
//            @Query("api_key") String api_key,
//            @Query("task_id") String task_id
//    );
//
//    @GET("API/Users/users_delete_image")
//    Call<DeleteImageResponse> deleteImage(
//            @Query("api_key") String api_key,
//            @Query("image_id") String image_id
//    );
//
//    @GET("API/Users/users_select_image")
//    Call<DeleteImageResponse> selectImage(
//            @Query("api_key") String api_key,
//            @Query("image_id") String image_id
//    );
//
//    @GET("API/Users/users_get_tasks")
//    Call<List<TaskListSingleItemResponse>> getTasks(
//            @Query("api_key") String api_key
//    );
//
//    @GET("API/Users/users_delete_task")
//    Call<DeleteImageResponse> deleteTask(
//            @Query("api_key") String api_key,
//            @Query("task_id") String task_id
//    );
//
//    @GET("API/Users/users_get_in_app_ad")
//    Call<BannerResponseModel> getBanner(
//            @Query("api_key") String api_key
//    );
//
//    @GET("API/Users/users_admob_seen")
//    Call<DeleteImageResponse> get40minutes(
//            @Query("api_key") String api_key,
//            @Query("task_id") String task_id
//            );
//
//    @GET ("API/Users/users_click_on_in_app_ad")
//    Call<DeleteImageResponse> iranAddClick (
//            @Query("api_key") String api_key,
//            @Query("ad_id") String ad_id
//    );
//
//    @GET("API/Users/users_get_countries")
//    Call<List<CountryModel>> getCountries(
//    );

}
