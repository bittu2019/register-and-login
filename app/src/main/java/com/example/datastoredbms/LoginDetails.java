package com.example.datastoredbms;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
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

public class LoginDetails extends AppCompatActivity {

    private AppCompatEditText etMail;
    private AppCompatEditText etPwd;
    private AppCompatButton btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);
        etMail = (AppCompatEditText) findViewById(R.id.et_mail);
        etPwd = (AppCompatEditText) findViewById(R.id.et_pwd);
        btnLog = (AppCompatButton) findViewById(R.id.btn_log);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myemail=etMail.getText().toString();
                String mypwd=etPwd.getText().toString();
                String url="http://192.168.43.247:8084/AndroidProjectDemo/Loginapi";
                if(myemail.equals("") || mypwd.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Email or Password can't be empty", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(),"Login successfull", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),Profile.class);
                            intent.putExtra("key_response",response.toString());
                            startActivity(intent);
                            etMail.setText("");
                            etPwd.setText("");
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Error : "+error, Toast.LENGTH_SHORT).show();
                            etMail.setText("");
                            etPwd.setText("");
                        }
                    }){
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap hm=new HashMap();
                            hm.put("key_myemail",myemail);
                            hm.put("key_mypwd",mypwd);
                            return hm;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            }
        });

    }
}