package com.dev.recyclica.dto;

import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("data")
    private User user;

    @SerializedName("error")
    private String error;

    public User getUser() {
        return user;
    }

    public String getError() {
        return error;
    }
}
