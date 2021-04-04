// Database file
package com.firstapp.carminder;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AutoUser {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "car_make")
    public String make;

    @ColumnInfo(name = "car_model")
    public String model;

    @ColumnInfo(name = "year")
    public int year;

    @ColumnInfo(name = "car_mileage")
    public int mileage;

    @ColumnInfo(name = "service")
    public boolean serviceCompleted;

    //public Service[] serviceArray;

    public AutoUser(String make, String model, int mileage, int year, boolean serviceCompleted){
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.serviceCompleted = serviceCompleted;
    }
}
