package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class MainActivity extends AppCompatActivity {
//    public Button button;
//    public ImageButton imageButton;
//    public FloatingActionButton floatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//I think we dont really need the listener unless you need it to do something else

        //this is the car profile button where someone could view their car info/schedule a service
//        imageButton = (ImageButton) findViewById(R.id.carProfile);

//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                launch_serviceSchedule(v);
//            }
//        });
//
//        //this is the add car button on the Garage screen
//        floatingButton = (FloatingActionButton) findViewById(R.id.addCarButton);
//
//                floatingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addCar(v);
//            }
//        });


        AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();

        AutoUser car1 = new AutoUser("Honda", "Civic", 81000, 1997, false);

        db.autoUserDao().insertAll(car1);

        List<AutoUser> autoUserList = db.autoUserDao().getMileage();

    }

    public void launch_serviceSchedule(View view) {
        Intent serviceScheduler = new Intent(this, serviceScheduler.class);
        startActivity(serviceScheduler);
    }

    public void addCar(View view) {
        Intent add_car = new Intent(this, add_car.class);
        startActivity(add_car);
    }
//
//    public void garage(View view)
//    {
//        finish();
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        startActivity(intent);
//    }

}

