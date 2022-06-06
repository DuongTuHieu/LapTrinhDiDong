package oltest.bai14nguyendinhchi;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddFile extends AppCompatActivity {

    File currentDir = Environment.getExternalStorageDirectory();
    private static final String FILE_NAME ="MyFile";
    EditText edtBH,edtNameBH;
    Button Save, BackMenu;
    String FileBH, FileNameBH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_file);

        edtBH = (EditText) findViewById(R.id.edtbh);
        Save = (Button) findViewById(R.id.btnSave);
        BackMenu = (Button) findViewById(R.id.btnBackMenu);
        edtNameBH = (EditText) findViewById(R.id.edtnamesong);


        BackMenu.setOnClickListener(XulyBackMenu);
        Save.setOnClickListener(XulySave);
    }


    //Button Luu
    View.OnClickListener XulySave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FileNameBH = edtNameBH.getText().toString();//Get ten bai hát
            FileBH = edtBH.getText().toString(); //Get loi bai hat
            FileOutputStream fOut = null;
            try {
                fOut = openFileOutput(FILE_NAME,MODE_PRIVATE);
                fOut.write(FileBH.getBytes());
                fOut.close();
                File fileDir = new File(getFilesDir(),FILE_NAME);
                Toast.makeText(getBaseContext(), "Tệp tin đã được lưu tại "+ fileDir, Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    };


    //BUTTON QUAYLAI
    View.OnClickListener XulyBackMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent tab2 = new Intent(AddFile.this, MainActivity.class);
            startActivity(tab2);
        }
    };


};