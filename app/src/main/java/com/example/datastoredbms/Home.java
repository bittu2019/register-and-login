package com.example.datastoredbms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void myregister(View view) {
        Intent intent = new Intent(Home.this,MainActivity.class);
        startActivity(intent);
    }

    public void mylogin(View view) {
        Intent intent = new Intent(Home.this, LoginDetails.class);
        startActivity(intent);

    }
}