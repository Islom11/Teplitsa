package com.example.greenhouses.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Data.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract DataDao dataDao();
}
