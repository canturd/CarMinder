package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class serviceScheduler extends AppCompatActivity {

//    private Button oilChange = (Button)findViewById(R.id.oilChange);
//    private Button brakes = (Button)findViewById(R.id.brakes);
//    private Button sparkPlugs = (Button)findViewById(R.id.sparkPlugs);
//    private Button tireChange = (Button)findViewById(R.id.tireChange);
//    private Button tireRotation = (Button)findViewById(R.id.tireRotation);
//    private Button alignment = (Button)findViewById(R.id.alignment);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void popup(View view) {

        //create new activity
        Intent popupScreen = new Intent(this, popup.class);

        //pass information form main to setting
        Button caller = (Button)findViewById(view.getId());
        String service = caller.getText().toString();

        //Use to pass other information about service (get from database)
//        if(caller == oilChange) {
//        }
//        else if(caller == brakes) {
//        }
//        else if(caller == sparkPlugs) {
//        }
//        else if(caller == tireChange) {
//        }
//        else if(caller == tireRotation) {
//        }
//        else {
//        }

        //send name of service to popup activity
        popupScreen.putExtra("SERVICE_NAME", service);

        //start activity
        startActivity(popupScreen);
    }
}