package com.example.ameller.mylightapp;

/**
 * Created by ameller on 10/27/17.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
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
    Button stripButton;
    SeekBar seekBarRed;
    TextView valueViewProgessRed;
    SeekBar seekBarGreen;
    TextView valueViewProgessGreen;
    SeekBar seekBarBlue;
    TextView valueViewProgressBlue;
    TextView txtColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_led);

        onButtonLed = (Button) findViewById(R.id.onButtonLed);
        onButtonLed.setOnClickListener(this);
        offButtonLed = (Button) findViewById(R.id.offButtonLed);
        offButtonLed.setOnClickListener(this);
        stripButton = (Button) findViewById(R.id.stripButton);
        stripButton.setOnClickListener(this);

        seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
        valueViewProgessRed = (TextView) findViewById(R.id.textViewProgressRed);
        seekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        valueViewProgessGreen = (TextView) findViewById(R.id.textViewProgressGreen);
        seekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);
        valueViewProgressBlue = (TextView) findViewById(R.id.textViewProgressBlue);

        txtColor = (TextView) findViewById(R.id.txtColor);

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

            case R.id.stripButton:
                task = new PostResponseAsyncTask(this);
                task.execute("http://192.168.1.103:8090/strip_led.php");

                break;

        }
    }

    public void pickColor (View view) {

        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Wybór koloru")
                .initialColor(0xffffff)
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int selectedColor, Integer[] integers) {
                        Log.d("DEBUG", String.valueOf(selectedColor));
                        Toast.makeText(Function_led.this, "Wybrany kolor:  " + Integer.toHexString(selectedColor), Toast.LENGTH_SHORT).show();
                        txtColor.setBackgroundColor(selectedColor);

                        txtColor.setText("" +Integer.toHexString(selectedColor));

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                String value = txtColor.getText().toString();

                                HttpClient httpclient = new DefaultHttpClient();
                                HttpPost httpPost = new HttpPost("http://192.168.1.103:8090/led_color.php");

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
                })

                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();

    }


    @Override
    public void processFinish(String s) {

    }
}
