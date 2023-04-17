package com.example.businessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class profileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText profile_name,
            profile_address,
            profile_mobile,
            profile_email,
            profile_vehicle_no,
            profile_vehicle_type,
            profile_vehicle_brand,
            profile_vehicle_subbrand,
            profile_vehicle_fueltype;
//            business_name,
//            business_contact,
//            business_email,
//            business_web,
    //business_workinghours;

    CardView btn_submit_business;

    String prs_name = "",
            prs_address = "",
            prs_email = "",
            prs_vehicle_no = "",
            prs_vehicle_type = "",
            prs_vehicle_brand = "",
            prs_vehicle_subbrand = "",
            prs_vehicle_fueltype = "";
    // Integer prs_mobile = 0;
//            prs_business_contact = 0,
//            prs_business_workinghours = 0;

//    String prs_business_name = "",
//            prs_business_email = "",
//            prs_business_website = "";

    String user_mobile;

    FirebaseDatabase firebaseDatabase;               //  Firebase Database
    FirebaseAuth firebaseAuth;                       //  Firebase Authentication
    DatabaseReference databaseReference;
    FirebaseAuth.AuthStateListener mAuthListener;//  Database Reference
    public Users users = new Users();
    private MenuItem item;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final Intent intent = getIntent();
        user_mobile = intent.getStringExtra("MOBILE_STR");

        //Find all the elements by ID
        profile_name = findViewById(R.id.pr_name);
        profile_address = findViewById(R.id.pr_address);
        profile_email = findViewById(R.id.pr_email);
    //    profile_mobile = findViewById(R.id.pr_mobile);
        profile_vehicle_no = findViewById(R.id.pr_vehicle_no);
        profile_vehicle_type = findViewById(R.id.pr_vehicle_type);
        profile_vehicle_brand = findViewById(R.id.pr_vehicle_brand);
        profile_vehicle_subbrand = findViewById(R.id.pr_vehicle_subbrand);
        profile_vehicle_fueltype = findViewById(R.id.pr_vehicle_fueltype);
//Business Activity Data
//        business_name = findViewById(R.id.pr_business_name);
//        business_contact = findViewById(R.id.pr_business_contact);
//        business_email = findViewById(R.id.pr_business_email);
//        business_web = findViewById(R.id.pr_business_website);
//        business_workinghours = findViewById(R.id.pr_business_workinghours);
//        btn_submit_business = findViewById(R.id.submit_text);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
//Onclick Listener on Sumbit Button

        findViewById(R.id.btn_submit_business).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                prs_name = profile_name.getText().toString();
                prs_address = profile_address.getText().toString();

                prs_email = profile_email.getText().toString();
                //prs_mobile = (Integer) Integer.parseInt((String.valueOf(profile_mobile)));
                prs_vehicle_no = profile_vehicle_no.getText().toString();
                prs_vehicle_type = profile_vehicle_type.getText().toString();
                prs_vehicle_brand = profile_vehicle_brand.getText().toString();
                prs_vehicle_subbrand = profile_vehicle_subbrand.getText().toString();
                prs_vehicle_fueltype = profile_vehicle_fueltype.getText().toString();
//                prs_business_email = business_email.getText().toString();
//                prs_business_website = business_web.getText().toString();
//                prs_business_contact = (Integer) Integer.parseInt(String.valueOf(prs_business_contact));
//                prs_business_workinghours = (Integer) Integer.parseInt(String.valueOf(prs_business_workinghours));


                Map<String, String> map = new HashMap<>();                  // Store value in firebase
                map.put("profilename", prs_name);
                map.put("profileaddress", prs_address);
                map.put("profileemail", prs_email);
                map.put("profilevehicleno", prs_vehicle_no);
                map.put("profilevehicletype", prs_vehicle_type);
                map.put("profilevehiclebrand", prs_vehicle_brand);
                map.put("profilevehiclesubbrand", prs_vehicle_subbrand);

                map.put("profilevehiclefuelType", prs_vehicle_fueltype);
//                map.put("Business Name", prs_business_name);
//
//                map.put("Business Email", prs_business_email);
//                map.put("Business Website", prs_business_website);

                //  Map<String, Integer>mapInt = new HashMap<>();
//                mapInt.put("Profile Mobile", prs_mobile);
//                mapInt.put("Business Contact", prs_business_contact);
//                mapInt.put("Business Working Hours", prs_business_workinghours);


                try {
                    databaseReference.child("users").child(user_mobile).child("customer_details").setValue(map);
                    Intent intent = new Intent(profileActivity.this, login.class);
                    intent.putExtra("MOBILE_STR", user_mobile);
                    startActivity(intent);
                }

                catch (Exception e) {
                    Log.e("MYAPP", "exception: " + e.getMessage());


                }
            }


        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_data, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = item.getItemId();

//        if (id == R.id.nav_home) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_tools) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}




