package com.company.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   // private List<User> userList = new ArrayList<>();
   // private RecyclerView recyclerView;
    Controller controller = new Controller(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        controller.start();
//        recyclerView = findViewById(R.id.list);
//        UserAdapter userAdapter = new UserAdapter(this, userList);
//        recyclerView.setAdapter(userAdapter);
    }

}