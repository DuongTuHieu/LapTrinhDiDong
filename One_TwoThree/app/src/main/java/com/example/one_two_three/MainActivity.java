package com.example.one_two_three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextDict;
    // đọc, đưa vào EditText
    void ReadSharedRef() {
        String  myRef_file = "myDict";
        // Lấy đối tượng để làm việc
        SharedPreferences mySH = getSharedPreferences(myRef_file,MODE_PRIVATE);
        // ĐỌc
        String val1= mySH.getString("1","null");
        String val2= mySH.getString("2","null");
//        // Đưa vào EditText
        String s= val1 + val2;

        editTextDict = (EditText) findViewById(R.id.editMyDict);
        editTextDict.setText(s);
    }

    // Tạo 1 file ref,  lưu dữ liệu
    // key -> value   :   1-->one, 2-->two
    // file: myDict
    void SaveSharedRef() {
        String  myRef_file = "myDict";
        // Lấy đối tượng để làm việc
        SharedPreferences mySH = getSharedPreferences(myRef_file,MODE_PRIVATE);
        //  Muốn ghi, ta phải lấy đối tượng Editor
        SharedPreferences.Editor   myEdit= mySH.edit();
        // Tiến hành ghi
        myEdit.putString("1","One");
        myEdit.putString("2","Two");
        myEdit.putString("3","Three");
        // Lưu lại thay đổi
        myEdit.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SaveSharedRef();
    }
}
