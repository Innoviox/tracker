package com.example.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.tracker.database.AppDatabase;
import com.example.tracker.database.entities.Event;

import java.util.Calendar;

public class AddEvent extends AppCompatActivity {

    private Button mbutton;
    private Switch mswitch;
    private EditText datePicker;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        mswitch = findViewById(R.id.switch1);
        mbutton = findViewById(R.id.submit_button);
        datePicker = findViewById(R.id.editTextDate);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getDatabase(getApplication());
                Boolean switchState = mswitch.isChecked();

                Event mevent = new Event();
                mevent.switch_value = switchState;
                db.databaseWriteExecutor.execute(() -> {
                    db.eventDao().insertAll(mevent);
                });
                Intent intent = new Intent(AddEvent.this,MainActivity.class);
                startActivity(intent);

            }
        });




    }
}