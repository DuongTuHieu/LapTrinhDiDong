package com.example.docfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> listSong = new ArrayList<String>();
        listSong.add("BaiHat1");
        listSong.add("BaiHat2");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listSong);
        ListView lv = (ListView)findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // lấy về tên bài hát
                String tenBaiHat = listSong.get(i);
                //chuyển activity
                Intent intentBH = new Intent(MainActivity.this, ShowLyricActivity.class);
                //Gói tên vào
                intentBH.putExtra("TenBH", tenBaiHat);
                startActivity(intentBH);
            }
        });
    }


}