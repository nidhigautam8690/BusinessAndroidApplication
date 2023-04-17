package com.example.businessapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;

public class forgot_password extends AppCompatActivity {
EditText mobile, pass;
CardView btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mobile=findViewById(R.id.mobile);
        pass= findViewById(R.id.pass);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(forgot_password.this,login.class);
                startActivity(intent);
            }
        });
    }
}
