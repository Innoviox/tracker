package com.example.tracker.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tracker.database.daos.EventDao;
import com.example.tracker.database.entities.Event;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EventDao userDao();
}