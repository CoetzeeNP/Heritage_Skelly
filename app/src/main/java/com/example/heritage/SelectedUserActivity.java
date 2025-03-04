package com.example.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectedUserActivity extends AppCompatActivity {

    TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_user);

        tvUser = findViewById(R.id.selectedUser);

        Intent intent = getIntent();

        if(intent.getExtras() != null) {
            UserModel userModel = (UserModel) intent.getSerializableExtra("data");

            tvUser.setText(userModel.getUserName());
        }
    }
}