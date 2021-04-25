package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

//    public Button button;
//    public ImageButton imageButton;
//    public FloatingActionButton floatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "We in main");


        AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();




        scheduled_services();
        past_services();

    }

    public void launch_serviceSchedule(View view) {
        Intent serviceScheduler = new Intent(this, serviceScheduler.class);
        startActivity(serviceScheduler);
    }

    public void addCar(View view) {
        Intent add_car = new Intent(this, add_car.class);
        startActivity(add_car);
    }

    //displays current/future scheduled services to home page
    public void scheduled_services ()
    {
        int counter = 0;
        TextView text = (TextView) findViewById(R.id.services_label);
        text.setText(String.valueOf(counter));
    }

    //displays past scheduled services to home page
    public void past_services ()
    {
        int counter = 0;
        TextView text = (TextView) findViewById(R.id.history_label);
        text.setText(String.valueOf(counter));
    }


}

