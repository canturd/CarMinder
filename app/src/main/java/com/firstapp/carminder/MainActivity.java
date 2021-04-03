package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_scheduler);
    }

    public void launch_serviceSchedule(View view) {
        Intent serviceScheduler = new Intent(this, serviceScheduler.class);
        startActivity(serviceScheduler);
    }
}

