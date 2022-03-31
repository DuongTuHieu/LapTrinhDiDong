package com.example.intent_laydulieuve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NhapLieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_lieu);
    }
    public void Nhap_QuayVe(View v){
        EditText edHT = (EditText) findViewById(R.id.edHoTen);
        EditText edNS = (EditText) findViewById(R.id.edNamSinh);
        String hoten = edHT.getText().toString();
        int namsinh = Integer.parseInt(edNS.getText().toString());
        Intent iKQnhapLieu = new Intent();
       iKQnhapLieu.putExtra("HT",hoten);
       iKQnhapLieu.putExtra("NS", namsinh);
       setResult(RESULT_OK,iKQnhapLieu);
       finish();

    }
}