// database file
package com.firstapp.carminder;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AutoUser.class}, version = 1, exportSchema = false)
public abstract class AutoUserDatabase extends RoomDatabase {

    public abstract AutoUserDao autoUserDao();


}
