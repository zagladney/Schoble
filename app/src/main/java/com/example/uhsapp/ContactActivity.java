package com.example.uhsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

public class ContactActivity extends AppCompatActivity {

    public String selectedItem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        //Instantiate text view for where contact info will be displayed
        TextView contactDisplay = findViewById(R.id.contactDisplay);
        contactDisplay.setText("Who do you need to talk to?");

        //Instantiate spinner (dropdown for departments)
        Spinner contactSelect = (Spinner) findViewById(R.id.spinner);

        //Back Button
        Button backButton = (Button) findViewById(R.id.backContactButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactDisplay.setText("");
                toMenuActivity();
            }
        });


        //Instantiate adapter to be used for department list
        ArrayAdapter<String> contactAdapter = new ArrayAdapter<String>(ContactActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.contacts));
        contactAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contactSelect.setAdapter(contactAdapter);

        //Button to check when "check" has been pressed and update info accordingly
        Button checkButton = (Button) findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contact = contactSelect.getSelectedItem().toString();
                if (contact.equals("Administration")) {
                    contactDisplay.setText("Principal Alberto Ranjel, alberto.ranjel@tusd1.org, (520)232-5904 \n\nAssistant Principal Andrea Evans, Andrea.Evans@tusd1.org, (520)232-5616 \n\nAssistant Principal Jeanette Apaez-Guitierrez, jeanette.apaezgutierrez@tusd1.org, (520)232-5912");
                    Linkify.addLinks(contactDisplay, Linkify.ALL);
                } else if (contact.equals("Counselors")) {
                    contactDisplay.setText("Thomas Donahue, Thomas.donahue@tusd1.org, (520)232-5918 \n\nKatrina Messing, Katrina.Messing@tusd1.org, (520)232-5907 \n\nMeghan Hammer, Meghan.Hammer@tusd1.org, (520)232-5666 \n\nAmy Villagio, amy.villagio2@tusd1.org, (520)232-5830 \n\nMarcos Flores, Marcos.Flores@tusd1.org, (520)232-5910 \n\nMegan Palos, megan.palos@tusd1.org, (520)232-5906");
                    Linkify.addLinks(contactDisplay, Linkify.ALL);
                }
            }
        });
    }

    public void toMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}