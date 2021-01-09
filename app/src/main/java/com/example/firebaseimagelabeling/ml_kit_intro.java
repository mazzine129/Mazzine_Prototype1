package com.example.firebaseimagelabeling;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ml_kit_intro extends AppCompatActivity {

    private ImageView play_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ml_kit_intro);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();

        play_button = findViewById(R.id.play_button);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ml_kit_intro.this, MainActivity.class));
            }
        });
    }
}