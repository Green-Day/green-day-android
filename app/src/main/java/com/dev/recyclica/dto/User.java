package com.dev.recyclica.dto;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("username")
    private String username;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("Phone")
    private int phone;

    public int getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(username + " ");
        sb.append(fullname);

        return sb.toString();
    }
}
