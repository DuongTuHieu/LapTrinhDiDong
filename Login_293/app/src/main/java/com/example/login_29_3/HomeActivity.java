package com.example.login_29_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    protected void onActivityResult(Intent data){

    String UserNameNhanDuoc = data.getStringExtra("UN");
        TextView UserN =(TextView) findViewById(R.id.tvUserNameNhan);
        UserN.setText(UserNameNhanDuoc);
    }

}