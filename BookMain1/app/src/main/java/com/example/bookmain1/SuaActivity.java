package com.example.bookmain1;

import static android.database.sqlite.SQLiteDatabase.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class SuaActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        db = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.bookmain1/MyBook.db", null);
        //Lấy về intent sửa đã gửi
        Intent intentS = getIntent();
        //Lấy ra dữ liệu đã gói thông qua key là masach
        //
        int maSachSua = intentS.getIntExtra("masach",0);
        //
        //Lấy các thông tin hiện tại, fill vào các điều kiển
        String[] thamsoTruyen ={String.valueOf(maSachSua)};
        Cursor cs = db.rawQuery("SELECT * FROM BOOKS where BookID=?", thamsoTruyen);
        int ma = cs.getInt(0);
        String ten = cs.getString(1);
    }
    void CapNhap(int maGoc,String tenMoi, int sotrangMoi,float giaMoi,String motaMoi){
        String[] thamsSoTruyen= {String.valueOf(maGoc)};
        ContentValues row = new ContentValues();
        row.put("BookName",tenMoi);
        row.put("Page",sotrangMoi);
        row.put("Price", giaMoi);
        row.put("Description", motaMoi);

        int kq = db.update("BOOKS",row,"BookID=?",thamsSoTruyen);
        if(kq == 0)
            Toast.makeText(this, "Không cập nhập được", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Cập nhập thành công", Toast.LENGTH_LONG).show();
    }
}