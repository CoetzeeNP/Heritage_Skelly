package com.example.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityChoose extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    private Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trueFullscreen();
        setContentView(R.layout.activity_choose);


        toolbar = findViewById(R.id.toolbar5);
        bottomNavigationView = findViewById(R.id.bottom_nav_navigation);
        btn1 = findViewById(R.id.btnSearchRoots);

        topBarBackBtn();
        buttons();
        bottomNav();

    }

    private void trueFullscreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void topBarBackBtn() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Set up the back button click listener
        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(ActivityChoose.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish(); // Close this activity
        });
    }
    private void buttons() {
        //Introduction button
        btn1.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityChoose.this, SearchActivity.class);
            startActivity(intent);
        });

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
}