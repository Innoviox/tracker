package com.example.tracker.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;


@Entity
public class Event {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "switch")
    public boolean switch_value;
}