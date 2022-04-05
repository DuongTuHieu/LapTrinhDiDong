package DuongTuHieu.Baikt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton B13,B15,B20;
    TextView tV;
    EditText edT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B13=(RadioButton) findViewById(R.id.B13);
        B15=(RadioButton) findViewById(R.id.B15);
        B20=(RadioButton) findViewById(R.id.B20);
        tV=(TextView) findViewById(R.id.tV);
        edT=(EditText) findViewById(R.id.edN);

    }
    public void xulyTip(View v){
        String sa = edT.getText().toString();
        int a = Integer.parseInt(sa);
        Float F13 = Float.valueOf((a * 13) / 100);
        Float F15 = Float.valueOf((a * 13) / 100);
        Float F20 = Float.valueOf((a * 13) / 100);
        if(B13.isChecked()){
            tV.setText("Số tiền Tip nhân được là: " + F13);
        }
        if(B15.isChecked()){
            tV.setText("Số tiền Tip nhân được là: " + F15);
        }
        if(B20.isChecked()){
            tV.setText("Số tiền Tip nhân được là: " + F20);
        }

    }
}