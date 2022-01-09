package com.example.datastoredbms;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText etName;
    private AppCompatEditText etEmail;
    private AppCompatEditText etPassword;
    private AppCompatEditText etGender;
    private AppCompatEditText etCity;
    private AppCompatButton btnRigister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = (AppCompatEditText) findViewById(R.id.et_name);
        etEmail = (AppCompatEditText) findViewById(R.id.et_email);
        etPassword = (AppCompatEditText) findViewById(R.id.et_password);
        etGender = (AppCompatEditText) findViewById(R.id.et_gender);
        etCity = (AppCompatEditText) findViewById(R.id.et_city);
        btnRigister = (AppCompatButton) findViewById(R.id.btn_rigister);
        btnRigister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                String gender=etGender.getText().toString();
                String city=etCity.getText().toString();
                String url="http://192.168.43.247:8084/AndroidProjectDemo/ResisterDemo";
                RequestQueue requestQueue =Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        etName.setText("");
                        etEmail.setText("");
                        etPassword.setText("");
                        etGender.setText("");
                        etCity.setText("");

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error : "+error, Toast.LENGTH_SHORT).show();
                        etName.setText("");
                        etEmail.setText("");
                        etPassword.setText("");
                        etGender.setText("");
                        etCity.setText("");
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap hm = new HashMap();
                        hm.put("key_name",name);
                        hm.put("key_email",email);
                        hm.put("key_password",password);
                        hm.put("key_gender",gender);
                        hm.put("key_city",city);
                        return hm;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });

    }
}