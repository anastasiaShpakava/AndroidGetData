package com.company.myapp;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<User>> {
   private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private RecyclerView recyclerView;
    private MainActivity mainActivity;

    public Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void start() {
        recyclerView = this.mainActivity.findViewById(R.id.list);

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
        ResultAdapter resultAdapter = new ResultAdapter(mainActivity, response.body());
        recyclerView.setAdapter(resultAdapter);
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        Log.d("error", "can't parse data: ", t);
    }
}
