package com.example.docfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ShowLyricActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lyric);
        //
        Intent BH = getIntent();
        //Lấy ra tên BH
        String tenBai = BH.getStringExtra("TenBH");
    }
}