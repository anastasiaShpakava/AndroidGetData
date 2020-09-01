package com.company.myapp;

import java.util.List;

import retrofit2.http.GET;

public interface ServerApi  {
    @GET("users")
    List<User> getUsers();
}
