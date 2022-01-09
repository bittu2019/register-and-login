package com.example.datastoredbms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    private AppCompatTextView tvName;
    private AppCompatTextView tvGender;
    private AppCompatTextView tvCity;
    String name,gender,city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvName = (AppCompatTextView) findViewById(R.id.tv_name);
        tvGender = (AppCompatTextView) findViewById(R.id.tv_gender);
        tvCity = (AppCompatTextView) findViewById(R.id.tv_city);

        String data=getIntent().getStringExtra("key_response");
        try {
            JSONObject obj=new JSONObject(data);
            JSONArray array = obj.getJSONArray("my_data");
            JSONObject jobj=array.getJSONObject(0);
            name=jobj.getString("db_name");
            gender=jobj.getString("db_gender");
            city=jobj.getString("db_city");
            tvName.setText("Name : "+name);
            tvGender.setText("Gender : "+gender);
            tvCity.setText("City : "+city);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}