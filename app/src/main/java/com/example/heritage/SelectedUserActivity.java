package com.example.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectedUserActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trueFullscreen();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_user);

        tvUser = findViewById(R.id.selectedUser);
        toolbar = findViewById(R.id.toolbar5);

        topBarBackBtn();

        Intent intent = getIntent();

        if(intent.getExtras() != null) {
            UserModel userModel = (UserModel) intent.getSerializableExtra("data");

            tvUser.setText(userModel.getUserName());
        }


    }

    private void topBarBackBtn() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(SelectedUserActivity.this, SearchResultsActivity.class);
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