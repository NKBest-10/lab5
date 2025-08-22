package com.example.lab51;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;   // Import ที่ต้องเพิ่ม
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;      // Import ที่ต้องเพิ่ม

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BrowseNote extends AppCompatActivity {

    Button home_button;

    // 1. ประกาศตัวแปรสำหรับ UI ใหม่ทั้งหมด
    EditText nameEditText;
    Button searchButton;
    ProgressBar progressBar;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        home_button = findViewById(R.id.home2);
        home_button.setOnClickListener(v -> {
            Intent Home_2 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(Home_2);
        });


        nameEditText = findViewById(R.id.name_edit_text);
        searchButton = findViewById(R.id.search_button);
        progressBar = findViewById(R.id.progress_bar);
        resultTextView = findViewById(R.id.result_text_view);

        searchButton.setOnClickListener(v -> startSearchProcess());
    }

    private void startSearchProcess() {
        String searchText = nameEditText.getText().toString().trim();

        progressBar.setVisibility(View.VISIBLE);
        resultTextView.setVisibility(View.GONE);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
                resultTextView.setVisibility(View.VISIBLE);
            });
        }).start();
    }
}