package com.example.tracker.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tracker.database.entities.Event;

import java.util.List;

@Dao
public interface EventDao {
    @Query("SELECT * FROM event")
    List<Event> getAll();

    @Query("SELECT * FROM event WHERE id IN (:eventIds)")
    List<Event> loadAllByIds(int[] eventIds);

    @Insert
    void insertAll(Event... users);

    @Delete
    void delete(Event user);
}