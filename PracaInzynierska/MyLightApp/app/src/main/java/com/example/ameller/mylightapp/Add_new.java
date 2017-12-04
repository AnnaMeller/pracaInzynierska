package com.example.ameller.mylightapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by ameller on 11/25/17.
 */

public class Add_new extends AppCompatActivity implements View.OnClickListener {

    Button saveButton;
    private EditText setName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

        setName = (EditText) findViewById(R.id.setName);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.saveButton:

                //String name = setName.getText().toString();
                //Bundle bundle = new Bundle();
                //bundle.putString("data", name);

                //Intent intent = new Intent(this, Choosing_light.class);
                //intent.putExtras(bundle);
                //startActivity(intent);

                Button myButton = new Button(this);
                myButton.setText("This");

                LinearLayout ll = (LinearLayout) findViewById(R.id.choosing_ll);
                ll.addView(myButton);


                //Button myButton = new Button(this);
                //myButton.setText(""+setName);

                //LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //View v = vi.inflate(R.layout.activity_choosing_light, null);

                //LinearLayout ll = ((LinearLayout) v.findViewById(R.id.choosing_ll));
                //ViewGroup.LayoutParams lp = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //ll.addView(myButton, lp);
                break;

        }
        }

    }
