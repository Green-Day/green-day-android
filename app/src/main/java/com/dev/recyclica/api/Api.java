package com.dev.recyclica.api;

import com.dev.recyclica.dto.Answer;
import com.dev.recyclica.dto.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("register")
    Call<Answer> getRegistratedUser(@Query("username") String username,
                                  @Query("fullname") String fullname,
                                  @Query("password") String password,
                                  @Query("phone") int phone);

    @POST("register")
    Call<Answer> getRegistratedUser(@Body User user,
                                    @Header("Content-Type") String header);
}
