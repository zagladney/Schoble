package com.example.uhsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Set up buttons

        //Calendar Button
        Button calendarButton = (Button) findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity(CalendarActivity.class);
            }
        });

        //Contact page button
        Button contactButton = (Button) findViewById(R.id.contactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { toActivity(ContactActivity.class);}
        });

        //Schedule page button
        Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { toActivity(ScheduleActivity.class);}
        });
    }

    public void toActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}