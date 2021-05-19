// Database file
package com.firstapp.carminder;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Update;

@Entity
public class AutoUser {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "car_make")
    public String make;

    @ColumnInfo(name = "car_model")
    public String model;

    @ColumnInfo(name = "year")
    public String year;

    @ColumnInfo(name = "car_mileage")
    public String mileage;

    @ColumnInfo(name = "car_name")
    public String name;

    @ColumnInfo(name = "service")
    public boolean serviceCompleted;

    //public Service[] serviceArray;

//    public AutoUser(String make, String model, int mileage, int year, boolean serviceCompleted){
//        this.make = make;
//        this.model = model;
//        this.year = year;
//        this.mileage = mileage;
//        this.serviceCompleted = serviceCompleted;
//    }

    public AutoUser(String make, String model, String year, String name, String mileage){
        this.make = make;
        this.model = model;
        this.year = year;
        this.name = name;
        this.mileage = mileage;
    }

    @Update
    public void updateMileage(AutoUser autoUser){};

    public int getUid() {
        return uid;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getMileage() {
        return mileage;
    }

    public String getName() {
        return name;
    }

    public boolean isServiceCompleted() {
        return serviceCompleted;
    }
}
