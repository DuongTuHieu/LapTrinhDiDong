package com.example.bookmain1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        //TaoBangVaThemDuLieu();
        //ThemMoiSach(6,"Mạng máy tính", 50, 10000, "Đây là sách mạng máy tính");

        NapSACHvaoListview();
        //CapNhat(2,"Dương Tư Hiệu", 60, 99999, "Đây là hiệu đẹp trai");

        Button nutXoa =(Button) findViewById(R.id.btnxoa);
        Button nutThem =(Button) findViewById(R.id.btnthem);
        Button nutsua =(Button) findViewById(R.id.btnsua);
        TextView edChon = (TextView) findViewById(R.id.edtMachon);

        nutXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSach = edChon.getText().toString();
                int ma = Integer.parseInt(maSach);
                XoaSach(ma);
            }
        });
        nutsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lấy mã sách vừa chọn
                String maSach = edChon.getText().toString();
                //Tạo intent
                Intent intentSua = new Intent();
                //gói dữ liệu
                intentSua.putExtra("masach", maSach);
                //Khời động SuaActivity
                startActivity(intentSua);
            }
        });
        nutThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThem = new Intent();
                startActivity(intentThem);
            }
        });


    }
    void ThemMoiSach(int ma,String ten, int sotrang,float gia,String mota){
    //String sqlThem ="INSERT INTO BOOKS VALUES("+ma + ",' "+ ten + " ',"+ sotrang +"," + gia+ " ," + " ,'" + mota +"' )";
    //db.execSQL(sqlThem);
        ContentValues row = new ContentValues();
        //put(key,value) key= tên cột, calue = giá trị
        row.put("BookID", ma);
        row.put("BookName",ten);
        row.put("Page",sotrang);
        row.put("Price", gia);
        row.put("Description", mota);
        long kq = db.insert("BOOKS",null,row);
        if(kq == -1)
            Toast.makeText(this, "Không thêm được", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Đã thêm thành công", Toast.LENGTH_LONG).show();

    }
    void XoaSach(int ma){
        String[] thamSoTruyen={String.valueOf(ma)};
        int kq = db.delete("BOOKS","BookID=?",thamSoTruyen);
        if (kq ==0)
            Toast.makeText(this, "Không xóa  được",Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "Xóa thành công",Toast.LENGTH_LONG).show();

    }
    }
    void CapNhat(int maGOC, String tenMOI, int sotrangMOI, float giaMOI, String motaMOI)
    {
        String[] thamSoTruyen={String.valueOf(maGOC)};
        ContentValues row = new ContentValues();
        // put (key, value)     key=tên cột, value= giá trị
        row.put("BookName", tenMOI);
        row.put("Page", sotrangMOI);
        row.put("Price", giaMOI);
        row.put("Description", motaMOI);
        //
        int kq = db.update("BOOKS",row,"BookID=?",thamSoTruyen);
        if (kq ==0)
            Toast.makeText(this, "Không cập nhật được",Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "Cập nhật thành công",Toast.LENGTH_LONG).show();
        }
    }
    void NapSACHvaoListview() {
        //1. Lấy tham chiếu đến Listview trong Layout
        ListView listView = (ListView) findViewById(R.id.lvSach);
        //2. Nguồn dữ liệu
        // Mỗi phần tử là một String, gồm:mã+tên+giá
        ArrayList<String>  dsSach = new ArrayList<String>();
        // Mở DB, select dữ liệu, đưa vào ArratList
        ///----------------
        Cursor cs = db.rawQuery("SELECT * FROM BOOKS",null);
        cs.moveToFirst();
        // duyệt từng dòng (bản ghi), tính toán
        while (true)
        {
            if (cs.isAfterLast()==true) break;
            // Lấy mã sách
            int ms = cs.getInt(0);  // Cột 0, ở dòng hiện tại
            // Lấy tên sách
            String tenSach = cs.getString(1);
            // Lấy giá bán
            Float gia=cs.getFloat(3);
            // Nối lại, để đưa vào arraylist
            String dong = String.valueOf(ms)+ " --- "+
                    tenSach + "----" + String.valueOf(gia);
            // đưa vào arrayList
            dsSach.add(dong);
            // Sang dòng (bản ghi tiếp)
            cs.moveToNext();

        }

        ///---------------
        //3. Adapter
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                dsSach);
        //Gắn vào Listview
        listView.setAdapter(adapter);
        // Bắt và xử lý sự kiện
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String dongChon = dsSach.get(i);
                // có dạng:   8 -- Tên sách  -- ...
                // Xử lý tách lấy phần mã
                int k= dongChon.indexOf(" "); // Tìm vị trí xuất hiện đầu tiên của khoảng trắng
                String ma = dongChon.substring(0, k);  // trích lấy phần mã
                //test thử bằng cách gán lên textvew chọn
                TextView edChon = (TextView) findViewById(R.id.edtMachon);
                edChon.setText(ma);
            }
        });
    }

    void TaoBangVaThemDuLieu() {
        //Lệnh tạo bảng
        // sqlXoaBang nếu đã có
        String sqlXoaBang ="DROP TABLE IF EXISTS BOOKS";
        db.execSQL(sqlXoaBang);
        String sqlTaoBang ="CREATE TABLE BOOKS(     BookID integer PRIMARY KEY, " +
                "   BookName text, " +
                "   Page integer, "+
                "   Price Float, "+
                "   Description text)";
        db.execSQL(sqlTaoBang);
        // Thêm bản ghi
        String sqlThem1= "INSERT INTO BOOKS VALUES(1, 'Java', 100, 9.99, 'Sách về java')";
        db.execSQL(sqlThem1);
        String sqlThem2= "INSERT INTO BOOKS VALUES(2, 'Android', 320, 19.00, 'Android cơ bản')";
        db.execSQL(sqlThem2);
        String sqlThem3= "INSERT INTO BOOKS VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui') ";
        db.execSQL(sqlThem3);
        String sqlThem4= "INSERT INTO BOOKS VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ')";
        db.execSQL(sqlThem4);
        String sqlThem5= "INSERT INTO BOOKS VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích')";
        db.execSQL(sqlThem5);
    }
}
