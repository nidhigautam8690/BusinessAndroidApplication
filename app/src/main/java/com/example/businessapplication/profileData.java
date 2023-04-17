package com.example.businessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class profileData extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView customer_pr_name, customer_pr_address, customer_pr_mobile, customer_pr_email;
           TextView customer_pr_vehicle_no, customer_pr_vehicle_type, customer_pr_vehicle_brand, customer_pr_vehicle_subbrand,customer_pr_vehicle_fuel_type;

           CardView profiledata_submit_text;
    FirebaseDatabase firebaseDatabase;               //  Firebase Database
    FirebaseAuth firebaseAuth;                       //  Firebase Authentication
    FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference databaseReference;             //  Database Reference

    String user_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_data);
        final Intent intent = getIntent();
        user_mobile = intent.getStringExtra("MOBILE_STR");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


        customer_pr_name = findViewById(R.id.customer_pr_name);
        customer_pr_address = findViewById(R.id.customer_pr_address);
        customer_pr_mobile = findViewById(R.id.customer_pr_mobile);
        customer_pr_email = findViewById(R.id.customer_pr_email);
        customer_pr_vehicle_no = findViewById(R.id.customer_pr_vehicle_no);
        customer_pr_vehicle_type = findViewById(R.id.customer_pr_vehicle_type);
        customer_pr_vehicle_brand= findViewById(R.id.customer_pr_vehicle_brand);
        customer_pr_vehicle_brand = findViewById(R.id.customer_pr_vehicle_subbrand);
        customer_pr_vehicle_fuel_type = findViewById(R.id.customer_pr_vehicle_fuel_type);





databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


        Map<String,String> map = (Map)dataSnapshot.getValue();
        String customer_name=map.get("profilename").toString();
        String customer_address=map.get("profileaddress").toString();
        String customer_email=map.get("profileemail").toString();

        String customer_vehicle_no=map.get("profilevehicleno").toString();

        String customer_vehicle_type=map.get("profilevehicletype").toString();


        String customer_vehicle_brand=map.get("profilevehiclebrand").toString();
        String customer_vehicle_fuel_type=map.get("profilevehiclefuelType").toString();
        customer_pr_name.setText(customer_name);

        customer_pr_address.setText(customer_address);

        customer_pr_email.setText(customer_email);
        customer_pr_vehicle_no.setText(customer_vehicle_no);
        customer_pr_vehicle_type.setText(customer_vehicle_type);
        customer_pr_vehicle_brand.setText(customer_vehicle_brand);
        customer_pr_vehicle_fuel_type.setText(customer_vehicle_fuel_type);










    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

        Toolbar toolbar = findViewById(R.id.toolbar);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
