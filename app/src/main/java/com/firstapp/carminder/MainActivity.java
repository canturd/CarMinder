package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<AutoUser> cars;
    public int pastServicesCount = 0;
    public int scheduledServicesCount;

//    public Button button;
//    public ImageButton imageButton;
//    public FloatingActionButton floatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scheduled_services();
        recyclerView = findViewById(R.id.recycler_view);   // recyclerView thing


        Log.d(TAG, "We in main");


        cars = new ArrayList<AutoUser>();

        AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();


        List<AutoUser> cars = db.autoUserDao().getAllCars();


        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // this you just gotta do recyclerView Thing
        adapter = new CarAdapter(cars);     // recyclerView thing
        recyclerView.setAdapter(adapter);   // recyclerView thing



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
        scheduledServicesCount = checkCount();

        TextView text = (TextView) findViewById(R.id.services_label);
        text.setText(String.valueOf(scheduledServicesCount));
    }

    public void isClicked (View view){
        scheduledServicesCount++;
    }

    //displays past scheduled services to home page
    public void past_services ()
    {
        TextView text = (TextView) findViewById(R.id.history_label);
        text.setText(String.valueOf(pastServicesCount));
    }

    public int checkCount() {
        int count = 0;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean oil_checked = prefs.getBoolean("oil_check", false);
        Boolean brake_check = prefs.getBoolean("brake_check", false);
        Boolean spark_check = prefs.getBoolean("spark_check", false);
        Boolean tireChan_check = prefs.getBoolean("tireChan_check", false);
        Boolean tireRot_check = prefs.getBoolean("tireRot_check", false);
        Boolean align_check = prefs.getBoolean("align_check", false);

        if (oil_checked == true)
        {
            count++;
        }
        if (brake_check == true)
        {
            count++;
        }
        if (spark_check == true)
        {
            count++;
        }
        if (tireChan_check == true)
        {
            count++;
        }
        if (tireRot_check == true)
        {
            count++;
        }
        if (align_check == true)
        {
            count++;
        }


        return count;

    }



}

