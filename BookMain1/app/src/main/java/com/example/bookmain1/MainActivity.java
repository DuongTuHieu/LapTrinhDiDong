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
                //TaoBangvathemDuLieu();
        //ThemMoiSach(6,"Mạng máy tính", 50, 10000, "Đây là sách mạng máy tính");
     //   CapNhap(2,"Dương Tư Hiệu", 60, 99999, "Đây là hiệu đẹp trai");

        NapSachVaoListView();
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
        String[] thamsSoTruyen= {String.valueOf(ma)};
        int kq = db.delete("BOOKS","BookID=?",thamsSoTruyen);
        if(kq == 0)
            Toast.makeText(this, "Không xóa được", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_LONG).show();

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dongChon = dsSach.get(position);
                //Xử lý tách lấy phần mã
                int k = dongChon.indexOf(" "); // tìm vị trí xuất hiện đầu tiên của khoảng trắng
                 String ma =   dongChon.substring(0,k);
                TextView edChon = (TextView) findViewById(R.id.edtMachon);
                edChon.setText("ID: " +ma);
            }
        });
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
