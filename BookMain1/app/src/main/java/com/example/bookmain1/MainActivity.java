package com.example.bookmain1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tạo mới/mở CSDL
        db = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.bookmain1/MyBook.db", null);
        //Ta che hàm sau lại, ở những lần chạy sau.Vì ta không muốn tạo CSDL lại từ đầu
            TaoBangvathemDuLieu();
        NapSachVaoListView();

    }

    void NapSachVaoListView() {
        //Lấy tham chiếu đến Listview trong Layout
        ListView listView =(ListView) findViewById(R.id.lvSach);
        //Nguồn dữ liệu
        ArrayList<String> dsSach = new ArrayList<String>();
        // Mở database, chọn dữ liệu, đưa vào ArrayList
                //----------
        Cursor cs = db.rawQuery("SELECT * FROM BOOKS", null);
        cs.moveToFirst();
        while (true){
            if(cs.isAfterLast()==true) break;
            //Lấy mã sách
            int ms = cs.getInt(0);
            //Lấy tên sách
             String ts = cs.getString(1);
             //Lấy giá bán
            float gb = cs.getFloat(3);
            String dong = String.valueOf(ms)+ " " + ts +"  "+ String.valueOf(gb)+"$";
            //Đưa vào arraylist
            dsSach.add(dong);
            cs.moveToNext();
        }
        //Adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dsSach);
        //Gắn vào Listview
        listView.setAdapter(adapter);
    }

    void TaoBangvathemDuLieu(){
        //Xóa bản nếu đã có
        String sqlXoaBang = "DROP TABLE IF EXISTS BOOKS";
        db.execSQL(sqlXoaBang);
        // Lệnh tạo bảng
        String sqlTaoBang = "CREATE TABLE BOOKS( BookID integer PRIMARY KEY," + "Book text," +
                "Page integer," +
                " Price Float, " +
                "Description text)";
        db.execSQL(sqlTaoBang);
        // Thêm bản ghi
        String sqlThem1 = "INSERT INTO BOOKS VALUES(1, 'Java', 100, 9.99, 'sách về java');\n";
        db.execSQL(sqlThem1);
        String sqlThem2 = "INSERT INTO BOOKS VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');\n";
        db.execSQL(sqlThem2);
        String sqlThem3 = "INSERT INTO BOOKS VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');\n";
        db.execSQL(sqlThem3);
        String sqlThem4 = "INSERT INTO BOOKS VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');\n";
        db.execSQL(sqlThem4);
        String sqlThem5 = "INSERT INTO BOOKS VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
        db.execSQL(sqlThem5);
    }
}
