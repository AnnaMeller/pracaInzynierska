package com.example.ameller.mylightapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ameller on 11/11/17.
 */

public class Time_picker extends AppCompatActivity implements View.OnClickListener {

    TimePicker timePicker;
    Button getTime;
    TextView timeView;
    Context context;
    Typeface tfc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        getTime = (Button) findViewById(R.id.getTime);
        timeView = (TextView) findViewById(R.id.timeView);
        tfc1 = Typeface.createFromAsset(getAssets(), "fonts/GenR102.TTF");
        getTime.setTypeface(tfc1);

        showTime();
    }

    public void showTime() {

        getTime.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Integer hour = timePicker.getCurrentHour();
                        Integer minute = timePicker.getCurrentMinute();

                        timeView.setText("" + hour + ":" + minute);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                String value = timeView.getText().toString();

                                HttpClient httpclient = new DefaultHttpClient();
                                HttpPost httpPost = new HttpPost("http://192.168.1.103:8090/time_sleep.php");

                                context = getApplicationContext();
                                Intent intent = new Intent(context, Function.class);
                                startActivity(intent);
                                finish();

                                try {
                                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                                    nameValuePairs.add(new BasicNameValuePair("value", value));
                                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                                    //Execute HTTP Post Request
                                    HttpResponse response = httpclient.execute(httpPost);
                                } catch (ClientProtocolException e) {

                                } catch (IOException e) {

                                }
                            }
                        }).start();
                        Toast.makeText(getApplicationContext(), "Światło włączy się o godzinie "+hour + ":" +minute, Toast.LENGTH_LONG).show();
                    }
                }

        );

    }

    @Override
    public void onClick(View view) {

    }
}
