package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class serviceScheduler extends AppCompatActivity {

    private static final String TAG = "serviceScheduler";
    //    private Button oilChange = (Button)findViewById(R.id.oilChange);
//    private Button brakes = (Button)findViewById(R.id.brakes);
//    private Button sparkPlugs = (Button)findViewById(R.id.sparkPlugs);
//    private Button tireChange = (Button)findViewById(R.id.tireChange);
//    private Button tireRotation = (Button)findViewById(R.id.tireRotation);
//    private Button alignment = (Button)findViewById(R.id.alignment);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_scheduler);

        CheckBox oil_check = (CheckBox) findViewById(R.id.oil_check);
        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("oil_check", false);
        oil_check.setChecked(checked);

        CheckBox brake_check = (CheckBox) findViewById(R.id.brake_check);
        boolean checked2 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("brake_check", false);
        brake_check.setChecked(checked2);

        CheckBox spark_check = (CheckBox) findViewById(R.id.spark_check);
        boolean checked3 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("spark_check", false);
        spark_check.setChecked(checked3);

        CheckBox tireChan_check = (CheckBox) findViewById(R.id.tireChan_check);
        boolean checked4 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("tireChan_check", false);
        tireChan_check.setChecked(checked4);

        CheckBox tireRot_check = (CheckBox) findViewById(R.id.tireRot_check);
        boolean checked5 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("tireRot_check", false);
        tireRot_check.setChecked(checked5);

        CheckBox align_check = (CheckBox) findViewById(R.id.align_check);
        boolean checked6 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("align_check", false);
        align_check.setChecked(checked6);



        AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();

        Log.d(TAG, "ServiceScheduler Joe's mileage is: " + db.autoUserDao().getMileage("Joe"));
    }


    public void popup(View view) {

        //create new activity
        Intent popupScreen = new Intent(this, popup.class);

        //pass information form main to setting
        Button caller = (Button) findViewById(view.getId());
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

    public void cancel_activity(View view) {
        //go back to previous activity
        startActivity(new Intent(serviceScheduler.this, MainActivity.class));
        finish();
    }

    public void isClicked (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.oil_check:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("oil_check", checked).commit();
                break;
            case R.id.brake_check:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("brake_check", checked).commit();
                break;
            case R.id.spark_check:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("spark_check", checked).commit();
                break;
            case R.id.tireChan_check:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("tireChan_check", checked).commit();
                break;
            case R.id.tireRot_check:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("tireRot_check", checked).commit();
                break;
            case R.id.align_check:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("align_check", checked).commit();
                break;
        }
    }

}