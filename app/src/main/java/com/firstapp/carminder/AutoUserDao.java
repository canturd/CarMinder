// database file
package com.firstapp.carminder;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AutoUserDao {

    @Insert
    void insertAll(AutoUser... autoUsers);

    @Query("SELECT * FROM AutoUser")
    List<AutoUser> getAllCars();

    //@Query("SELECT * FROM AutoUser")
    //List<AutoUser> getMileage();

    @Query("SELECT car_mileage FROM Autouser WHERE car_name=:name")
    String getMileage(String name);
}

