package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import android.app.Notification;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.firstapp.carminder.MyNotificationChannel.CHANNEL_1_ID;
import static com.firstapp.carminder.MyNotificationChannel.CHANNEL_2_ID;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String SHARED_PREF_NAME = "mypref";
    //    TextView Text_mileage;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<AutoUser> cars;
    public int pastServicesCount = 0;
    public int scheduledServicesCount;
    public int startingMileage;
    public int oilNotifyMileage;
    public int brakesNotifyMileage;
    public int sparkNotifyMileage;
    public int tireChanNotifyMileage;
    public int tireRotNotifyMileage;
    public int alignNotifyMileage;
    public int[] serviceMileages =  {5000, 50000, 30000, 50000, 3000, 6000};

    /*******************************************************************
     * Notification
     *******************************************************************/
    private NotificationManagerCompat notificationManager;
    //*******************************************************************

//    public Button button;
//    public ImageButton imageButton;
//    public FloatingActionButton floatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create My notification
        notificationManager = NotificationManagerCompat.from(this);

        scheduled_services();
        //remind_services();
        recyclerView = findViewById(R.id.recycler_view);   // recyclerView thing


        Log.d(TAG, "We in main");


        cars = new ArrayList<AutoUser>();

        AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();


        List<AutoUser> cars = db.autoUserDao().getAllCars();

        // this you just gotta do recyclerView Thing
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CarAdapter(cars);     // recyclerView thing
        recyclerView.setAdapter(adapter);   // recyclerView thing

        Log.d(TAG, "We in main");
        String carNameTemp = "MyCar";
        Log.d(TAG, "Retrieved Mileage from Joe: " + db.autoUserDao().getMileage(carNameTemp));



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

    //increments scheduled services count in My Garage based on how many service boxes are checked
    public void isClicked (View view){
        scheduledServicesCount++;
    }

    //displays past scheduled services to home page
    public void past_services ()
    {
        TextView text = (TextView) findViewById(R.id.history_label);
        text.setText(String.valueOf(oilNotifyMileage));
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
            setNotifyMileage();
            remind_services();

        }
        if (brake_check == true)
        {
            count++;

            //setNotifyMileage();
            remind_services();
        }
        if (spark_check == true)
        {
            count++;
            //setNotifyMileage();
            remind_services();
        }
        if (tireChan_check == true)
        {
            count++;
            //setNotifyMileage();
            remind_services();
        }
        if (tireRot_check == true)
        {
            count++;
            //setNotifyMileage();
            remind_services();
        }
        if (align_check == true)
        {
            count++;
            //setNotifyMileage();
            remind_services();
        }


        return count;

    }

    public int setNotifyMileage(){


        AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();


        SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean oil_checked = prefs2.getBoolean("oil_check", false);
        Boolean brake_check = prefs2.getBoolean("brake_check", false);
        Boolean spark_check = prefs2.getBoolean("spark_check", false);
        Boolean tireChan_check = prefs2.getBoolean("tireChan_check", false);
        Boolean tireRot_check = prefs2.getBoolean("tireRot_check", false);
        Boolean align_check = prefs2.getBoolean("align_check", false);

//        SharedPreferences prefs2 = getSharedPreferences("carMileage", MODE_PRIVATE);
//        startingMileage = prefs2.getString("car_mileage", "");

        //pastServicesCount=Integer.parseInt(startingMileage);
        startingMileage = Integer.parseInt(db.autoUserDao().getMileage("MyCar"));

        if (oil_checked == true)
        {

            oilNotifyMileage = serviceMileages[0] + startingMileage;
            return oilNotifyMileage;
        }
        if (brake_check == true)
        {
            brakesNotifyMileage = serviceMileages[1] + startingMileage;
            return  brakesNotifyMileage;
        }
        if (spark_check == true)
        {
            sparkNotifyMileage = serviceMileages[2] + startingMileage;
            return  sparkNotifyMileage;
        }
        if (tireChan_check == true)
        {
            tireChanNotifyMileage = serviceMileages[3] + startingMileage;
            return  tireChanNotifyMileage;
        }
        if (tireRot_check == true)
        {
            tireRotNotifyMileage = serviceMileages[4] + startingMileage;
            return tireRotNotifyMileage;
        }
        if (align_check == true)
        {
            alignNotifyMileage = serviceMileages[5] + startingMileage;
            return alignNotifyMileage;
        }

        return 0;
    }

    private void remind_services(){

        AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean oil_checked = prefs.getBoolean("oil_check", false);
        Boolean brake_check = prefs.getBoolean("brake_check", false);
        Boolean spark_check = prefs.getBoolean("spark_check", false);
        Boolean tireChan_check = prefs.getBoolean("tireChan_check", false);
        Boolean tireRot_check = prefs.getBoolean("tireRot_check", false);
        Boolean align_check = prefs.getBoolean("align_check", false);
        startingMileage = Integer.parseInt(db.autoUserDao().getMileage("MyCar"));

        if (oil_checked == true)
        {
            if(serviceMileages[0]-startingMileage <= 300 || startingMileage > serviceMileages[0]){
                sendOnChannel1(0,"Reminder",
                        "You are due for the Oil Service!");
            }
        }
        if (brake_check == true)
        {
            if(serviceMileages[1]-startingMileage <= 300 || startingMileage > serviceMileages[1]){
                sendOnChannel1(1,"Reminder",
                        "You are due for the Brakes Service!");
            }

        }
        if (spark_check == true)
        {
            if(serviceMileages[2]-startingMileage <= 300 || startingMileage > serviceMileages[2]){
                sendOnChannel2(2,"Reminder",
                        "You are due for the Spark Plugs Service!");
            }
        }
        if (tireChan_check == true)
        {
            if(serviceMileages[3]-startingMileage <= 300 || startingMileage > serviceMileages[3]){
                sendOnChannel1(3,"Reminder",
                        "You are due for the Tire Service!");
            }
        }
        if (tireRot_check == true)
        {
            if(serviceMileages[4]-startingMileage <= 300 || startingMileage > serviceMileages[4]){
                sendOnChannel2(4,"Reminder",
                        "You are due for the Tire Rotation Service!");
            }
        }
        if (align_check == true)
        {
            if(serviceMileages[5]-startingMileage <= 300 || startingMileage > serviceMileages[5]){
                sendOnChannel1(5,"Reminder",
                        "You are due for the Alignment Service!");
            }
        }
    }

    private void sendOnChannel1( int ID,
            String textTitle, String textMessage) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.carminder_logo)
                .setContentTitle(textTitle)
                .setContentText(textMessage)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(ID,notification);
    }

    private void sendOnChannel2(int ID,
            String textTitle, String textMessage) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.carminder_logo)
                .setContentTitle(textTitle)
                .setContentText(textMessage)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(ID,notification);
    }




}