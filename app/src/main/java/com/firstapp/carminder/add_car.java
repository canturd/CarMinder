package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class add_car extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
    }

    public void cancel_activity(View view) {
        //go back to previous activity
        finish();
    }
}