package DuongTuHieu.Baikt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}