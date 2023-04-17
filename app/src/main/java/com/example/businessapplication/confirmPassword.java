package com.example.businessapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;
//Define all the variables
public class confirmPassword extends AppCompatActivity {
    EditText cp_pass, cp_confirmpass;
   // RadioButton ownerid, customerid;
   // RadioGroup radioOpt;

    Users users;
    String user_mobile;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String password="",cpassword="";
//    private String radioValue="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {                //Store the reference
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);

        final Intent intent = getIntent();
        user_mobile = intent.getStringExtra("MOBILE");
        cp_pass = findViewById(R.id.cp_pass);
        cp_confirmpass = findViewById(R.id.cp_confirmpass);

//        customerid= findViewById(R.id.customerid);

        //radio group id
//        radioOpt= findViewById(R.id.radioOpt);
//        radioOpt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                ownerid = findViewById(checkedId);
//
//                switch (checkedId)
//                {
//                    case R.id.
//                }
//            }
//        });

        //radiovalue of owner
        //radioValue=ownerid.getText().toString();


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference();
        users = new Users();                                            //Initatiated the users class


        findViewById(R.id.btn_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=cp_pass.getText().toString();          //Store the entered value in Editext
                cpassword=cp_confirmpass.getText().toString();

                if(password.isEmpty()){
                    cp_pass.setError("Enter password");
                }
                else if(cpassword.isEmpty()){
                    cp_confirmpass.setError("Enter confirm password");
                }
                else if(!password.equals(cpassword)){
                    Toast.makeText(getApplicationContext(),"Password not match",Toast.LENGTH_LONG).show();
                }
                else {
                    Map<String,String>map=new HashMap<>();                  // Store value in firebase
                    map.put("mobile",user_mobile);
                    map.put("password",password);
                    try{
                        databaseReference.child("users").child(user_mobile).setValue(map);

                        Intent intent = new Intent(confirmPassword.this, login.class);


                        startActivity(intent);
                    }catch (Exception e){

                    }



                }

            }
        });



        findViewById(R.id.btn_backlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirmPassword.this, login.class);
                startActivity(intent);
            }
        });

    }



}