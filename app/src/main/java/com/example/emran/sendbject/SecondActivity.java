package com.example.emran.sendbject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by emran on 11/9/2015.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txtVw = (TextView) findViewById(R.id.txtVw);

        //get intent object
        PersonData dene = (PersonData) getIntent().getSerializableExtra(MainActivity.INTENT_OBJECT_KEY);

        if (dene != null) {
            txtVw.setText("Name: " + dene.getName() + ", ID: " + dene.getId());
        } else {
            txtVw.setText("Is null");
        }
    }
}

