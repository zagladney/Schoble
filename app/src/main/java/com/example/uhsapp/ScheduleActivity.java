package com.example.uhsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        //Set up buttons

        //Back button
        Button backButton = (Button) findViewById(R.id.backScheduleButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity(MenuActivity.class);
            }
        });

        //Add class button
        Button addClassButton = (Button) findViewById(R.id.addClassButton);
        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity(AddClassActivity.class);
            }
        });

    }

    public void toActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}