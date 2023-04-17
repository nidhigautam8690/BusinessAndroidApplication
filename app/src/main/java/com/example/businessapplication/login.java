package com.example.businessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.util.Map;
import java.util.logging.ConsoleHandler;

@SuppressWarnings("unused")
public class login extends AppCompatActivity {
    EditText username,password;//Username and Password
    FirebaseDatabase firebaseDatabase;               //  Firebase Database
    FirebaseAuth firebaseAuth;                       //  Firebase Authentication
    FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference databaseReference;             //  Database Reference
    CardView btn_sign_in;

    private String mobile_str="",password_str="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        findViewById(R.id.btn_sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password_str=password.getText().toString();
                mobile_str=username.getText().toString();
                if(mobile_str.isEmpty()){
                    username.setError("Enter mobile");
                }else if(password_str.isEmpty()){
                    password.setError("Enter password");
                }else {

                    databaseReference.child("users").child(mobile_str).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Map<String,String> map = (Map)dataSnapshot.getValue();             //create map with database
                           String mob= map.get("mobile").toString();
                           String pass= map.get("password").toString();

                            if(mob.equals(mobile_str)&&pass.equals(password_str)){


                                Intent intent = new Intent(login.this,profileActivity.class);
                                intent.putExtra("MOBILE_STR", mobile_str);
                                startActivity(intent);

                            }else {
                                Toast.makeText(getApplicationContext(),"Wrong Mobile or Password",Toast.LENGTH_LONG).show();

                            }
                              }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });




                }


            }
        });




        findViewById(R.id.btn_forgotpass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this, forgot_password.class);

                startActivity(intent);
            }
        });
    }

//    private void showData(DataSnapshot dataSnapshot) {
//    }
}
