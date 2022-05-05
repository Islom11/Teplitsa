package com.example.greenhouses.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM 'Data'")
    List<Data> getAll();

    @Insert
    void insert(Data data);

    @Delete
    void delete(Data data);

    @Query("DELETE FROM 'Data'")
    void deleteAll();
}
