package com.example.ameller.mylightapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

public class Function extends AppCompatActivity implements View.OnClickListener, AsyncResponse {

    Button onButton;
    Button offButton;
    SeekBar brightnessBar;
    TextView valueView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        onButton = (Button) findViewById(R.id.onButton);
        onButton.setOnClickListener(this);
        offButton = (Button) findViewById(R.id.offButton);
        offButton.setOnClickListener(this);
        brightnessBar = (SeekBar) findViewById(R.id.brightnessBar);
        valueView = (TextView) findViewById(R.id.valueView);


        brightnessBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar brightnessBar, int progress, boolean fromUser) {
                valueView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar brightnessBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar brightnessBar) {

            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.onButton:
                PostResponseAsyncTask task = new PostResponseAsyncTask(this);
                task.execute("http://188.122.20.9:8090/off.php");

                break;

            case R.id.offButton:
                task = new PostResponseAsyncTask(this);
                task.execute("http://188.122.20.9:8090/on.php");

                break;
        }

    }

  /*  public void postData() {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("192.168.1.103:8090/IntensityLight.php");

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair ());
        }
    }*/

    @Override
    public void processFinish(String s) {

    }
}
