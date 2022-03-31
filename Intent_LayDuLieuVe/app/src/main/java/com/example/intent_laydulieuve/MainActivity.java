package com.example.intent_laydulieuve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void NhapLieu(View v){
        Intent iNhap = new Intent(this, NhapLieuActivity.class);
        startActivityForResult(iNhap, 8000);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode ==8000)
            if (resultCode == RESULT_OK)
            {
                String hotenNhanDuoc = data.getStringExtra("HT");
                int namsinhNhanDuoc = data.getIntExtra("NS", 2022);
                TextView tvHT = (TextView) findViewById(R.id.tvHoTen);
                TextView tvNS = (TextView) findViewById(R.id.tvNamSinh);
                tvHT.setText(hotenNhanDuoc);
                tvNS.setText(String.valueOf(namsinhNhanDuoc));
            }
        else
                Toast.makeText(this,"Trả về thất bại",Toast.LENGTH_LONG);
        else
            super.onActivityResult(requestCode,resultCode,data);
    }
}