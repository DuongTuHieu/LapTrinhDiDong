package com.example.login_29_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void Login(View v){
        EditText edUN =(EditText) findViewById(R.id.edtUserName);
        String Username = edUN.getText().toString();
        Intent iQuiz = new Intent(this,HomeActivity.class);
        iQuiz.putExtra("UN",Username);
        startActivity(iQuiz);

    }
}