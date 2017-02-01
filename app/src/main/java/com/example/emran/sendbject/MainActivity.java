package com.example.emran.sendbject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_OBJECT_KEY = "CustomObjectKey";
    private EditText txtName, txtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainButton = (Button) findViewById(R.id.btnSendObj);
        txtName = (EditText) findViewById(R.id.edtTxtName);
        txtID = (EditText) findViewById(R.id.edtTxtID);

        //set click listener
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get user name and id
                String name = txtName.getText().toString().trim();
                String id = txtID.getText().toString().trim();

                //Initialize new person object
                final PersonData dataObj = new PersonData(name, id);
                sendObjectOtherActivity(dataObj);
            }
        });
    }

    /*User define method*/
    private void sendObjectOtherActivity(PersonData dataObj) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(INTENT_OBJECT_KEY, dataObj);
        startActivity(intent);
    }
}
