 package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        //get default activity screen size
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        //set new screen size for popup
        getWindow().setLayout((int)(width*0.8), (int)(height*0.6));

        Intent intent = getIntent();
        String serviceName = intent.getStringExtra("SERVICE_NAME");
        ((TextView)findViewById(R.id.serviceName)).setText(serviceName);

        populate_rec_mileage(serviceName);

    }

    public void populate_rec_mileage(String serviceName)
    {
        //populating popup screen recommended mileage fields
        String oil_mileage = "5,000";
        String brake_mileage = "50,000";
        String spark_mileage = "30,000";
        String tireChan_mileage = "50,000";
        String tireRot_mileage = "3,000";
        String Align_mileage = "6,000";
        TextView text = (TextView) findViewById(R.id.mileage);
        switch (serviceName)
        {
            case "Oil Change":
                text.setText(oil_mileage);
                break;
            case "Brakes":
                text.setText(brake_mileage);
                break;
            case "Spark Plugs":
                text.setText(spark_mileage);
                break;
            case "Tire Change":
                text.setText(tireChan_mileage);
                break;
            case "Tire Rotation":
                text.setText(tireRot_mileage);
                break;
            case "Alignment":
                text.setText(Align_mileage);
                break;
        }
    }

}