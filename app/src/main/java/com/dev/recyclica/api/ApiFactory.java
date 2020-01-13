package com.dev.recyclica.api;

import com.dev.recyclica.api.model.UnsafeOkHttpClient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static final Object LOCK = new Object();

    private static Api api;

    public static Api getInstance() {
        synchronized (LOCK) {
            OkHttpClient unsafeClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
            if (api == null)
                api = new Retrofit.Builder()
                        .baseUrl(ApiConfig.url)
                        .client(unsafeClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(Api.class);
        }
        return api;
    }
}
