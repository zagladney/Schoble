package com.example.uhsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.tlaabs.timetableview.Schedule;
import com.github.tlaabs.timetableview.TimetableView;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;


public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        TextView dayCaption = findViewById(R.id.dayCaption);

        //Check what day it is and set according message
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                dayCaption.setText("Today is Sunday. No class!");
            case Calendar.SATURDAY:
                dayCaption.setText("Today is Saturday. No class!");
            case Calendar.MONDAY:
                dayCaption.setText("Today is Monday.");
            case Calendar.TUESDAY:
                dayCaption.setText("Today is Tuesday.");
            case Calendar.WEDNESDAY:
                dayCaption.setText("Today is Wednesday.");
            case Calendar.THURSDAY:
                dayCaption.setText("Today is Thursday.");
            case Calendar.FRIDAY:
                dayCaption.setText("Today is Friday.");
        }

        //Set up buttons
        TimetableView timetable = (TimetableView) findViewById(R.id.timetable);
        timetable.setOnStickerSelectEventListener(new TimetableView.OnStickerSelectedListener() {
            @Override
            public void OnStickerSelected(int idx, ArrayList<Schedule> schedules) {

            }
        });
        //Back button
        Button backButton = (Button) findViewById(R.id.backScheduleButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity(MenuActivity.class);
            }
        });

        //Read from data

    }

    public void toActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}