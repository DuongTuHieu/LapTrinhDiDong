package com.example.bai19_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView DanhSach;
    TextView textView;
    ArrayList<Hieu> hieu=new ArrayList<>();
    Hieu[] hieus={
            new Hieu(R.drawable.traidat, "Linux"),
            new Hieu(R.drawable.sao, "C"),
            new Hieu(R.drawable.sao, "C++"),
            new Hieu(R.drawable.traidat, "Java"),
            new Hieu(R.drawable.traidat, "Python"),
            new Hieu(R.drawable.traidat, "Pascal"),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void init() {
        DanhSach=(ListView) findViewById(R.id.lvDanhSach);
        textView = (TextView) findViewById(R.id.textview);
        Collections.addAll(hieu, hieus);
        CustomAdapter adapter=new CustomAdapter(MainActivity.this, hieu);
        DanhSach.setAdapter(adapter);

        //
        DanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int arg2, long arg3) {
                textView.setText(("vị trí = " + arg2 ) );
            }
        });


    }

}