package com.example.pabji.appturistica.APIHelpers;

import com.example.pabji.appturistica.models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by pabji on 01/06/2016.
 */
public interface TurismAPI {
    @FormUrlEncoded
    @POST("api_examen.php")
    Call<ResponseModel> receiveSomePlaces (@Header("Content-Type") String content_type, @Field("key") String key, @Field("latitude") String latitude, @Field("longitude") String longitude);
}
