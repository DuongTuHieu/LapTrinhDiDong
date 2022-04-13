package com.example.vd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoTV;
    ArrayList<String> nationsList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nationsList = new ArrayList<>();
        nationsList.add("Australia");
        nationsList.add("England");
        nationsList.add("VietNam");
        nationsList.add("Albania");
        nationsList.add("USA");
        nationsList.add("Algeria");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,nationsList);
        autoTV = (AutoCompleteTextView) findViewById(R.id.attv);
        autoTV.setAdapter(adapter);
    }
}