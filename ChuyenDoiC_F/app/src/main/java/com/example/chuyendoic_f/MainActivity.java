package com.example.chuyendoic_f;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button btn1, btn2, btn3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.edt1);
        edt2 = (EditText)findViewById(R.id.edt2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

    }
    public void xulyCF(View v){
    String sc = edt2.getText().toString();
    int C = Integer.getInteger(sc);
    float F = C*(9/5)+32;
        String chuoiF= String.valueOf(F);
        edt1.setText(chuoiF);
    }
    public void xulyFC(View v){
        String sf = edt1.getText().toString();
        int F = Integer.getInteger(sf);
        float C = (F-32)/(9/5);
        String chuoiC = String.valueOf(C);
        edt2.setText(chuoiC);
}
}