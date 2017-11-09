package com.example.ameller.mylightapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

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
import java.util.concurrent.ArrayBlockingQueue;


public class Function extends AppCompatActivity implements View.OnClickListener, AsyncResponse {

    Button onButton;
    Button offButton;
    SeekBar brightnessBar;
    TextView valueView;
    TextView time;
    TimePicker timePicker;
    Button timeButton;
    TextView timeView;


    private ArrayBlockingQueue<Integer> mQueue = new ArrayBlockingQueue<Integer>(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        onButton = (Button) findViewById(R.id.onButton);
        onButton.setOnClickListener(this);
        offButton = (Button) findViewById(R.id.offButton);
        offButton.setOnClickListener(this);
        timeView = (TextView) findViewById(R.id.timeView);

        showTime();


/*        brightnessBar = (SeekBar) findViewById(R.id.brightnessBar);
        valueView = (TextView) findViewById(R.id.valueView);


        brightnessBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            
            @Override
            public void onProgressChanged(SeekBar brightnessBar, int progress, boolean fromUser) {
                valueView.setText("" + progress);

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String value = valueView.getText().toString();

                        HttpClient httpclient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://192.168.1.103:8090/led.php");

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
            
            

               /* valueView = (TextView) findViewById(R.id.valueView);
                HashMap postData = new HashMap();

                postData.put("value", valueView.getText().toString());

                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://192.168.1.101:8090/intensityLED.php");

                context = getApplicationContext();
                Intent intent = new Intent(context, Function.class);
                startActivity(intent);

        }); */

    }

    public void showTime() {
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timeButton = (Button) findViewById(R.id.timeButton);

        timeButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        // Toast.makeText(getBaseContext(), timePicker.getCurrentHour() + " : " + timePicker.getCurrentMinute(),
                        //   Toast.LENGTH_SHORT).show();

                        Integer hour = timePicker.getCurrentHour();
                        Integer minute = timePicker.getCurrentMinute();

                        timeView.setText("" + hour + ":" + minute);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                String value = timeView.getText().toString();

                                HttpClient httpclient = new DefaultHttpClient();
                                HttpPost httpPost = new HttpPost("http://192.168.1.103:8090/time_sleep.php");

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
                }
        );
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.onButton:
                PostResponseAsyncTask task = new PostResponseAsyncTask(this);
                task.execute("http://192.168.1.103:8090/on.php");

                break;

            case R.id.offButton:
                task = new PostResponseAsyncTask(this);
                task.execute("http://192.168.1.103:8090/off.php");

                break;
        }

    }


    @Override
    public void processFinish(String s) {

    }
}