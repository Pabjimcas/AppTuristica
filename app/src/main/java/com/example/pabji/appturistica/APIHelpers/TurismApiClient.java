package com.example.pabji.appturistica.APIHelpers;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pabji on 01/06/2016.
 */
public class TurismAPIClient {
    public static final String API_BASE_URL = "http://ns225819.ovh.net/scripts_externos/android/";

    private static OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()

                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static TurismAPI createService() {

        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(TurismAPI.class);
    }
}
