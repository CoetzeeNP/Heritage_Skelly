package com.example.heritage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity implements UsersAdapter.SelectedUser {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;

    List<UserModel> userModelList = new ArrayList<>();

    String[] names = {"Richard", "Alice", "Hannah", "David"};

    UsersAdapter usersAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        trueFullscreen();
        setContentView(R.layout.activity_search_results);


        bottomNavigationView = findViewById(R.id.bottom_nav_navigation);
        recyclerView = findViewById(R.id.recyclerview1);
        toolbar = findViewById(R.id.toolbar5);


        bottomNav();

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
        topBarBackBtn();
    }

    @Override
    public void selectedUser(UserModel userModel) {
        startActivity( new Intent( SearchResultsActivity.this, SelectedUserActivity.class).putExtra("data", userModel));
    }

    private void bottomNav() {
        if (bottomNavigationView != null) {
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.nav_home) {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    return true;
                }
                else if(item.getItemId() == R.id.nav_search)
                {
                    Intent intent = new Intent(this, SearchActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            });
        }
    }
    private void topBarBackBtn() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Set up the back button click listener
        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(SearchResultsActivity.this, SearchActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish(); // Close this activity
        });
    }

    private void trueFullscreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}