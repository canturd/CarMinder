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
    List<AutoUser> getMakeModelMileage();

   // @Query("SELECT * FROM AutoUser")
   // List<AutoUser> getMileage();

}

