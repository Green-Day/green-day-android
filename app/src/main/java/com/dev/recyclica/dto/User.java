package com.dev.recyclica.dto;

import com.google.gson.annotations.SerializedName;

public class User {
    public User(String username, String fullname, String password, String email) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
    }

    @SerializedName("username")
    private String username;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("Phone")
    private String phone;

    public String getPhone() {
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
}
