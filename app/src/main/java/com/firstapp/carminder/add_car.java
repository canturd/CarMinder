package com.firstapp.carminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class add_car extends AppCompatActivity {

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

        //how to get input out of drop down
        //String input = getText.getText().toString();
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