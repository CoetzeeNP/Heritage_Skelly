package com.example.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Make the activity full screen
        trueFullscreen();
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button4);
        bottomNavigationView = findViewById(R.id.bottom_home_navigation);
        buttons();
        bottomNav();
    }

    private void trueFullscreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void buttons() {
        //Introduction button
        button.setOnClickListener(view -> {
        Intent intent = new Intent(MainActivity.this, ForgottenHighwayActivity.class);
            startActivity(intent);
        });
    }

    private void bottomNav() {
        if (bottomNavigationView != null) {
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.nav_search) {
                    Intent intent = new Intent(this, ActivityChoose.class);
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