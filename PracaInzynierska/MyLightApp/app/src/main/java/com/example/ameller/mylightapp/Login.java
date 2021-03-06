package com.example.ameller.mylightapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Login extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    EditText etUserName, etPassword;
    Button btnLogin;
    Context context;
    Typeface tfc1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        tfc1 = Typeface.createFromAsset(getAssets(), "fonts/GenR102.TTF");
        btnLogin.setTypeface(tfc1);
        etPassword.setTypeface(tfc1);
        etUserName.setTypeface(tfc1);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnLogin:
                HashMap postData = new HashMap();
                postData.put("mobile", "android");
                postData.put("txtUsername", etUserName.getText().toString());
                postData.put("txtPassword", etPassword.getText().toString());


                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://192.168.1.103:8090/login.php");

                //context = getApplicationContext();
                //Intent intent = new Intent(context, Choosing_light.class);
                //startActivity(intent);

                break;

        }
    }

    @Override
    public void processFinish(String result) {
        //Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        if (result.equals("success")) {
            context = getApplicationContext();
            Intent intent = new Intent(context, Choosing_light.class);
            startActivity(intent);
        }
        else {
            result = "Niepowodzenie";
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }
    }
}
