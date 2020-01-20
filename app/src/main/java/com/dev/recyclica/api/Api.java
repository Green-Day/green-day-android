package com.dev.recyclica.api;

import com.dev.recyclica.dto.Answer;
import com.dev.recyclica.dto.Error;
import com.dev.recyclica.dto.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("register")
    Call<Error> getRegistratedUser(@Body User user,
                                   @Header("Content-Type") String header);

    @POST("register")
    Call<Answer> login(@Body User user, @Header("Content-Type") String header);
}
