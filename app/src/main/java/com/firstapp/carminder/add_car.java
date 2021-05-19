package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class add_car extends AppCompatActivity {

    private static final String TAG = "CreateCar";
    private static final String SHARED_PREF_NAME = "mypref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        //set up drop down of makes
        String[] makes = getResources().getStringArray(R.array.makes);
        AutoCompleteTextView editText = findViewById(R.id.car_make);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, makes);
        editText.setAdapter(adapter);

        //set up drop down of years
        String[] years = getResources().getStringArray(R.array.year);
        AutoCompleteTextView editText1 = findViewById(R.id.car_year);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, years);
        editText1.setAdapter(adapter1);

        //set up drop down of models
        String[] models = getResources().getStringArray(R.array.model);
        AutoCompleteTextView editText2 = findViewById(R.id.car_model);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, models);
        editText2.setAdapter(adapter2);

        //how to get input out of drop down. this is what we might use to know what the user selected from the drop down to store it
        //String input = getText.getText().toString();



        final AutoUserDatabase db = Room.databaseBuilder(getApplicationContext(),
                AutoUserDatabase.class, "autoUser-database").allowMainThreadQueries().build();

        EditText carName;
        EditText carMake;
        EditText carModel;
        EditText carYear;
        EditText carMileage;
        Button saveCar;

        carName = findViewById(R.id.car_name);
        carMake = findViewById(R.id.car_make);
        carModel = findViewById(R.id.car_model);
        carYear = findViewById(R.id.car_year);
        carMileage = findViewById(R.id.car_mileage);
        saveCar = findViewById(R.id.addCarButton);


        //pass starting mileage to shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String mileage = sharedPreferences.getString("carMileage", null);
        if (mileage != null)
        {
            Intent intent = new Intent(add_car.this, MainActivity.class);
            startActivity(intent);
        }

        saveCar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("carMileage", carMileage.getText().toString());
                editor.apply();
                Intent intent = new Intent(add_car.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(add_car.this, "Car mileage successfully saved.", Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onClick: name: " + carName.getText().toString());
                Log.d(TAG, "onClick: make: " + carMake.getText().toString());
                Log.d(TAG, "onClick: model: " + carModel.getText().toString());
                Log.d(TAG, "onClick: year: " + carYear.getText().toString());
                Log.d(TAG, "onClick: mileage: " + carMileage.getText().toString());
                db.autoUserDao().insertAll(new AutoUser(
                        carMake.getText().toString(),
                        carModel.getText().toString(),
                        carYear.getText().toString(),
                        carName.getText().toString(),
                        carMileage.getText().toString()));
                startActivity(new Intent(add_car.this, MainActivity.class));
            }

        });

    }

    public void cancel_activity(View view) {
        //go back to previous activity
        finish();
    }

    public void add_car(View view) {
        //add car to database
        finish();
    }
}