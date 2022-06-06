package oltest.bai13nguyendinhchi;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Add = (Button) findViewById(R.id.btnAddSong);
        Button View = (Button) findViewById(R.id.btnViewSong);

        Add.setOnClickListener(OpenTabAddSong);
        View.setOnClickListener(ViewTabAddSong);
    }


    //  nếu người dùng cho phép thì đọc và tải tệp.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Đã cấp quyền", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Quyền chưa được cấp", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



    View.OnClickListener OpenTabAddSong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent tab2 = new Intent(MainActivity.this, AddFile.class);
            startActivity(tab2);
        }
    };

    View.OnClickListener ViewTabAddSong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent tab3 = new Intent(MainActivity.this, ViewFile.class);
            startActivity(tab3);
        }
    };
}