package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class serviceScheduler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_scheduler);
    }

    public void onClick(View view) {
        findViewById(R.id.brakes_button);

    }
}