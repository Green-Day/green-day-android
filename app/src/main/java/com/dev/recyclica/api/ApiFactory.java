package com.dev.recyclica.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static final Object LOCK = new Object();

    private static Api api;

    public static Api getInstance() {
        synchronized (LOCK) {
            if (api == null)
                api = new Retrofit.Builder()
                        .baseUrl(AppConfig.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(Api.class);
        }
        return api;
    }
}
