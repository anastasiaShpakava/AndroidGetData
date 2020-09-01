package com.company.myapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<User>> {
    static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
public void start () {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ServerApi serverApi = retrofit.create(ServerApi.class);

    Call<List<User>> users = serverApi.getUsers();
    users.enqueue(this);
}

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        if (response.isSuccessful()) {
            System.out.println("response " + response.body().size());
        } else {
            System.out.println("response code " + response.code());
        }
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        System.out.println("fail" + t);
    }
}
