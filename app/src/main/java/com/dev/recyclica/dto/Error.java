package com.dev.recyclica.dto;

import com.google.gson.annotations.SerializedName;

public class Error {
    @SerializedName("error")
    String error;

    public String getError() {
        return error;
    }
}
