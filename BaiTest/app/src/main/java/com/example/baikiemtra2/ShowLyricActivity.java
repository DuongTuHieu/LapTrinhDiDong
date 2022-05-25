package com.example.baikiemtra2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ShowLyricActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lyric);
        //
        Intent BT = getIntent();
        //Lấy ra tên BT
        String tenBai = BT.getStringExtra("tenBaiTho");
    }
}
