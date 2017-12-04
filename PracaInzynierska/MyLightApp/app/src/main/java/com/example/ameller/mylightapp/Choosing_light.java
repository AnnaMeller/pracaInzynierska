package com.example.ameller.mylightapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by ameller on 10/22/17.
 */

public class Choosing_light extends AppCompatActivity implements View.OnClickListener{

    Button lampButton;
    Button ledButton;
    Button addButton;
    Context context;
    static String setName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_light);

        lampButton = (Button) findViewById(R.id.lampButton);
        lampButton.setOnClickListener(this);

        ledButton = (Button) findViewById(R.id.ledButton);
        ledButton.setOnClickListener(this);

        //addButton = (Button) findViewById(R.id.addButton);
        //addButton.setOnClickListener(this);

    }

    @Override
    public void onClick (View view) {

        switch (view.getId()) {

            case R.id.lampButton:

                context = getApplicationContext();
                Intent intent = new Intent(context, Function.class);
                startActivity(intent);

                break;

            case R.id.ledButton:

                context = getApplicationContext();
                Intent intent_led = new Intent(context, Function_led.class);
                startActivity(intent_led);

                break;

            /*case R.id.addButton:

                context = getApplicationContext();
                Intent intent_add = new Intent(context, Add_new.class);
                startActivity(intent_add);

                //Button myButton = new Button(this);

                //LinearLayout ll = (LinearLayout) findViewById(R.id.choosing_ll);
                //ViewGroup.LayoutParams lp = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //ll.addView(myButton, lp);
                //myButton.setText("This");

                //Bundle nameData = getIntent().getExtras();
                //String name = nameData.getString("data");
                //myButton.setText(""+name);

                break;*/

        }

    }


}
