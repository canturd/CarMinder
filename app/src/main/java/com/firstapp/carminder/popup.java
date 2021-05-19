 package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

 public class popup extends AppCompatActivity {
     public int scheduledServicesCount = 0;

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

            //populate popup screen for toyota corolla 2021
        populate_rec_mileage(serviceName);
        populate_rec_type(serviceName);
        populate_est_cost(serviceName);




//        //toggle switch in popup service activity
//        switchCompat = findViewById(R.id.switch_compat);
//
//        SharedPreferences sharedPreferences = getSharedPreferences("com.firstapp.carminder", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        switchCompat.setChecked(sharedPreferences.getBoolean("switch", false));
//
//        switchCompat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(switchCompat.isChecked())
//                {
//                    editor.putBoolean("switch", true);
//                    editor.apply();
//                }
//                if (!switchCompat.isChecked())
//                {
//                    editor.putBoolean("switch", false);
//                    editor.apply();
//                }
//                editor.commit();
//                Toast.makeText(popup.this, "Service Tracker Saved.", Toast.LENGTH_SHORT).show();
//            }
//        });



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

     public void populate_rec_type(String serviceName)
     {
         //populating popup screen recommended mileage fields
         String oil_type = "Full Synthetic";
         String brake_type = "Cross Drilled and Slotted";
         String spark_type = "Genuine Toyota Spark Plugs";
         String tireChan_type = "p205/55r16";
         String tireRot_type = "N/A";
         String Align_type = "Toyota specifications";
         TextView text = (TextView) findViewById(R.id.type);
         switch (serviceName)
         {
             case "Oil Change":
                 text.setText(oil_type);
                 break;
             case "Brakes":
                 text.setText(brake_type);
                 break;
             case "Spark Plugs":
                 text.setText(spark_type);
                 break;
             case "Tire Change":
                 text.setText(tireChan_type);
                 break;
             case "Tire Rotation":
                 text.setText(tireRot_type);
                 break;
             case "Alignment":
                 text.setText(Align_type);
                 break;
         }
     }

     public void populate_est_cost(String serviceName)
     {
         //populating popup screen recommended mileage fields
         String oil_cost = "$69 - $128";
         String brake_cost = "$150 - $300";
         String spark_cost = "$124 - $144";
         String tireChan_cost = "$100 - $150 / tire";
         String tireRot_cost = "$35 - $44";
         String Align_cost = "$172 - $216";
         TextView text = (TextView) findViewById(R.id.cost);
         switch (serviceName)
         {
             case "Oil Change":
                 text.setText(oil_cost);
                 break;
             case "Brakes":
                 text.setText(brake_cost);
                 break;
             case "Spark Plugs":
                 text.setText(spark_cost);
                 break;
             case "Tire Change":
                 text.setText(tireChan_cost);
                 break;
             case "Tire Rotation":
                 text.setText(tireRot_cost);
                 break;
             case "Alignment":
                 text.setText(Align_cost);
                 break;
         }
     }

}