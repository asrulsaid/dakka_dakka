package com.example.dakka.API;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://192.168.42.57/dakka/";
    public static Retrofit getClient() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                HttpUrl httpUrl = originalRequest.url()
                        .newBuilder()
                        .build();

                originalRequest = originalRequest.newBuilder()
                        .url(httpUrl)
                        .build();

                return chain.proceed(originalRequest);
            }
        }).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
