package com.example.businessapplication;



import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class signupActivity extends AppCompatActivity {
    Spinner spinner;
    EditText mobile,otp;
    FirebaseAuth mAuth;
    String codeSent;
    TextView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


 spinner=findViewById(R.id.country);
 spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));
 mobile=findViewById(R.id.mobile);
 otp=findViewById(R.id.otp);
 mAuth =FirebaseAuth.getInstance();


Users users = new Users();
test=findViewById(R.id.already_register_signin);
test.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(signupActivity.this, login.class);

        startActivity(intent);
    }
});



        findViewById(R.id.sendCode).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              sendVerificationCode();
          }
      });

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifySignInCode();
            }
        });

    }


    private void verifySignInCode(){
        String code=otp.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);



    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            String user_mobile=mobile.getText().toString();
                            Intent intent = new Intent(signupActivity.this,confirmPassword.class);
                            intent.putExtra("MOBILE",user_mobile);
                            startActivity(intent);


                        } else if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                            Toast.makeText(getApplicationContext(),"Incorrect Verification", Toast.LENGTH_LONG).show();

                        }
                    }

                });
    }

    public void sendVerificationCode(){
        String code=CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];
        String phone= mobile.getText().toString();



        if(phone.isEmpty()){
            mobile.setError("Phone is required");
            mobile.requestFocus();
            return;
        }

        if(phone.length()<10){
            mobile.setError("Enter a valid length");
            mobile.requestFocus();
            return;

        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
               "+"+code+ phone,

                     // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {


        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent=s;

        }
    };



}
