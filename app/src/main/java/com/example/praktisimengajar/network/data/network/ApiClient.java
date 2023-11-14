package com.example.praktisimengajar.network.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(15, TimeUnit.SECONDS);
            builder.connectTimeout(15, TimeUnit.SECONDS);

            OkHttpClient client = builder.build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface getInterface() {
        return getRetrofitInstance().create(ApiInterface.class);
    }
}
