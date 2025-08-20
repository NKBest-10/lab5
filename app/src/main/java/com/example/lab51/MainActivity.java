package com.example.lab51;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button infoNoteButton,login_button,addNoteButton,browesNoteButton;
    ImageView logo;

    ProgressBar Progress;

    EditText editTextNameMainActivity;
    Spinner roleSpinnerMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        addNoteButton = findViewById(R.id.button);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addNote = new Intent(getApplicationContext(), AddNoteActivity.class);
                startActivity(addNote);
            }
        });

        infoNoteButton = findViewById(R.id.button2);
        infoNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoNote = new Intent(getApplicationContext(), infoMainActivity.class);
                startActivity(infoNote);
            }
        });

        logo = findViewById(R.id.imageView);
        logo.setImageResource(R.drawable.neco_arc_book);

        Progress = findViewById(R.id.progressBar);
        Progress.setVisibility(View.GONE);

        browesNoteButton = findViewById(R.id.BrowesNote_button);
        browesNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Progress.setVisibility(View.VISIBLE);
                new Thread(() ->{
                    try{
                        Thread.sleep(2000);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    runOnUiThread(()->{
                        Progress.setVisibility(View.GONE);
                        Intent Browes_Note = new Intent(getApplicationContext(),BrowseNote.class);
                        startActivity(Browes_Note);
                    });

                }).start();


            }
        });


    }
}