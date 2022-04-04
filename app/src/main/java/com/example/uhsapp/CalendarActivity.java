package com.example.uhsapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    private static SimpleDateFormat compareDate = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
    public ArrayList<Event> eventsArray = new ArrayList<Event>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        TextView eventList = findViewById(R.id.eventList);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);


        //Create events

        Event holiday = new Event(Color.GREEN, 1650006000000L, "Spring Holiday");
        Event actDay = new Event(Color.RED, 1649314800000L, "ACT (11th grade), ACT Aspire, ACT Practice Exam");

        eventsArray.add(holiday);
        eventsArray.add(actDay);

        //Open day info upon click

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                String message = "";
                int count = 0;
                for (Event event : eventsArray) {
                    if (compareDate.format(new Date(event.getTimeInMillis())).compareTo(compareDate.format(dateClicked)) == 0 && count < 3) {
                        message = message + (count + 1) + ": " + (String) event.getData() + "\n";
                        count++;
                    }
                }
                if (count == 0) {
                    eventList.setText("There aren't any events on this day.");
                } else {
                    eventList.setText(message);
                }
            }
            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });


    }

}