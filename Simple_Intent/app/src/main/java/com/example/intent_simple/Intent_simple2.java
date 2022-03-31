package com.example.intent_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Intent_simple2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_simple2);
    }
    public void QuayVe(View v){
        Intent iManHinhCHINH = new Intent(this, MainActivity.class);
        startActivity(iManHinhCHINH);
    }
}