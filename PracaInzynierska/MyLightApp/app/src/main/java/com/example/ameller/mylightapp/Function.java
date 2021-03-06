package com.example.ameller.mylightapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;


public class Function extends AppCompatActivity implements View.OnClickListener, AsyncResponse {

    Button onButton;
    Button offButton;
    Context context;
    Button timeButton;
    TextView timeView;


    //private ArrayBlockingQueue<Integer> mQueue = new ArrayBlockingQueue<Integer>(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        onButton = (Button) findViewById(R.id.onButton);
        onButton.setOnClickListener(this);

        offButton = (Button) findViewById(R.id.offButton);
        offButton.setOnClickListener(this);

        timeButton = (Button) findViewById(R.id.timeButton);
        timeButton.setOnClickListener(this);
        timeView = (TextView) findViewById(R.id.timeView);

        //showTime();

    }

  /*  public void showTime() {
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timeButton = (Button) findViewById(R.id.timeButton);

        timeButton.setOnClickListener(
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
    }*/

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

            case R.id.timeButton:
                context = getApplicationContext();
                Intent intent = new Intent(context, Time_picker.class);
                startActivity(intent);

                break;
        }

    }


    @Override
    public void processFinish(String s) {

    }
}