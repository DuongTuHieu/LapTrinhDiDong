package com.example.baikiemtra1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2,edt3;
    TextView tv1,tv2,txtkq,tv3;
    Button btnCV,btnDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv3 = (TextView) findViewById(R.id.tv3);
        txtkq = (TextView) findViewById(R.id.txtkq);
        tv2 = (TextView) findViewById(R.id.tv2);
        btnCV = (Button) findViewById(R.id.btnCV);
        btnDT = (Button) findViewById(R.id.btnDT);
    }
    public void xulyCV(View v){
        String sa = edt1.getText().toString();
        String sb = edt2.getText().toString();
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int CV = (a+b)*2;
        String chuoiCV = String.valueOf(CV);
        txtkq.setText("Chu vi hình bình hành là: " + chuoiCV+"cm");
    }
    public void xulyDT(View v){
        String sa = edt1.getText().toString();
        String sh = edt3.getText().toString();
        int a = Integer.parseInt(sa);
        int h = Integer.parseInt(sh);
        int DT = a*h;
        String chuoiDT = String.valueOf(DT);
        txtkq.setText("Diện tích hình bình hành là: " + chuoiDT +"cm^2");
    }
}