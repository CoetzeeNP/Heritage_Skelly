package com.example.heritage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity implements UsersAdapter.SelectedUser {

    Toolbar toolbar;
    RecyclerView recyclerView;

    List<UserModel> userModelList = new ArrayList<>();

    String[] names = {"Richard", "Alice", "Hannah", "David"};

    UsersAdapter usersAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_results);

        recyclerView = findViewById(R.id.recyclerview1);
        toolbar = findViewById(R.id.toolbar5);

        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        for (String s : names) {
            UserModel userModel = new UserModel(s);

            userModelList.add(userModel);
        }

        usersAdapter = new UsersAdapter(userModelList,this);

        recyclerView.setAdapter(usersAdapter);

    }

    @Override
    public void selectedUser(UserModel userModel) {
        startActivity( new Intent( SearchResultsActivity.this, SelectedUserActivity.class).putExtra("data", userModel));
    }
}