package com.example.ameller.mylightapp;

/**
 * Created by ameller on 10/27/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

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


public class Function_led extends AppCompatActivity implements View.OnClickListener, AsyncResponse {

    Button onButtonLed;
    Button offButtonLed;
    SeekBar seekBarRed;
    TextView valueViewProgessRed;
    SeekBar seekBarGreen;
    TextView valueViewProgessGreen;
    SeekBar seekBarBlue;
    TextView valueViewProgressBlue;


    //private ArrayBlockingQueue<Integer> mQueue = new ArrayBlockingQueue<Integer>(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_led);

        onButtonLed = (Button) findViewById(R.id.onButtonLed);
        onButtonLed.setOnClickListener(this);
        offButtonLed = (Button) findViewById(R.id.offButtonLed);
        offButtonLed.setOnClickListener(this);

        seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
        valueViewProgessRed = (TextView) findViewById(R.id.textViewProgressRed);
        seekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        valueViewProgessGreen = (TextView) findViewById(R.id.textViewProgressGreen);
        seekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);
        valueViewProgressBlue = (TextView) findViewById(R.id.textViewProgressBlue);


        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar brightnessBar, int progress, boolean fromUser) {

                valueViewProgessRed.setText("" + progress);

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String value = valueViewProgessRed.getText().toString();

                        HttpClient httpclient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://192.168.1.103:8090/led_red.php");

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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar brightnessBar, int progress, boolean fromUser) {

                valueViewProgessGreen.setText("" + progress);

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String value = valueViewProgessGreen.getText().toString();

                        HttpClient httpclient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://192.168.1.103:8090/led_green.php");

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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar brightnessBar, int progress, boolean fromUser) {

                valueViewProgressBlue.setText("" + progress);

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String value = valueViewProgressBlue.getText().toString();

                        HttpClient httpclient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://192.168.1.103:8090/led_blue.php");

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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {

        Context context = this;

        switch (view.getId()) {
            case R.id.onButtonLed:
                PostResponseAsyncTask task = new PostResponseAsyncTask(this);
                task.execute("http://192.168.1.103:8090/on_led.php");

                break;

            case R.id.offButtonLed:
                task = new PostResponseAsyncTask(this);
                task.execute("http://192.168.1.103:8090/off_led.php");

                break;
        }


    }

    @Override
    public void processFinish(String s) {

    }
}
