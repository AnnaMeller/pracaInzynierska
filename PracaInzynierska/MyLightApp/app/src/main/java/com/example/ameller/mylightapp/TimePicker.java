package com.example.ameller.mylightapp;

/**
 * Created by ameller on 10/26/17.



import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        //Get a new instance of Calendar
        final Calendar c= Calendar.getInstance();
        int hourOfDay = c.get(c.HOUR_OF_DAY); //Current Hour
        int minute = c.get(c.MINUTE); //Current Minute
        int second = c.get(c.SECOND); //Current Second

        //Get the widgets reference from XML layout
        final TextView time = (TextView) findViewById(R.id.tv);
        TimePicker tp = (TimePicker) findViewById(R.id.tp);

        //Display the TimePicker initial time
        tv.setText("Initial Time\nH:M:S | " + hourOfDay + ":" + minute + ":" + second);

        //Set a TimeChangedListener for TimePicker widget
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                //Display the new time to app interface
                tv.setText("Time changed\nH:M | "+hourOfDay + ":" + minute);
            }
        });
    }
}
*/