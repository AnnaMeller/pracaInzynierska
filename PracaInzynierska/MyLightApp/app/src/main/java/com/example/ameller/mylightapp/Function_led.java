package com.example.ameller.mylightapp;

/**
 * Created by ameller on 10/27/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
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
    SeekBar brightnessBarLed;
    TextView valueViewLed;
    TextView valueViewColor;

    //private ArrayBlockingQueue<Integer> mQueue = new ArrayBlockingQueue<Integer>(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_led);

        onButtonLed = (Button) findViewById(R.id.onButtonLed);
        onButtonLed.setOnClickListener(this);
        offButtonLed = (Button) findViewById(R.id.offButtonLed);
        offButtonLed.setOnClickListener(this);

        brightnessBarLed = (SeekBar) findViewById(R.id.brightnessBarLed);
        valueViewLed = (TextView) findViewById(R.id.valueViewLed);
        valueViewColor = (TextView) findViewById(R.id.valueViewColor);


        brightnessBarLed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar brightnessBar, int progress, boolean fromUser) {
                valueViewLed.setText("" + progress);

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String value = valueViewLed.getText().toString();

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

            ColorPickerDialogBuilder
                .with(context)
                .setTitle("Choose color")
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(12)
                .setOnColorChangedListener(new OnColorChangedListener() {


                    @Override
                    public void onColorChanged(int selectedColor) {
                        // Handle on color change
                        Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));
                        valueViewColor.setText("" + Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor)));
                    }
                });
    }


    @Override
    public void processFinish(String s) {

    }
}