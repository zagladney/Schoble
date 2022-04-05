package com.example.uhsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class AddClassActivity extends AppCompatActivity {

    //Instantiate editTexts for input
    public EditText classInput, teacherInput, periodInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        classInput = findViewById(R.id.classNameInput);
        teacherInput = findViewById(R.id.teacherNameInput);

        //Back Button
        Button backToScheduleButton = (Button) findViewById(R.id.backToScheduleButton);
        backToScheduleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                toActivity(ScheduleActivity.class);
            }
        });

        //Menu Button
        Button backToMenuButton = (Button) findViewById(R.id.backToMenuButton);
        backToMenuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                toActivity(MenuActivity.class);
            }
        });

        //Period Spinner
        Spinner periodInput = (Spinner) findViewById(R.id.periodSpinner);
        ArrayAdapter<String> periodAdapter = new ArrayAdapter<String>(AddClassActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.periods));
        periodAdapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        periodInput.setAdapter(periodAdapter);

        //Add Button
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String classTitle = classInput.getText().toString();
                String teacherName = teacherInput.getText().toString();
                int periodNumber = Integer.parseInt(periodInput.getSelectedItem().toString());
                writeToFile("classDataFile.txt", classTitle + ", " + teacherName + ", " + periodNumber);
            }
        });
    }

    public void toActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void writeToFile(String fileName, String content) {
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
            Toast.makeText(getApplicationContext(), "Added class succesfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}