package com.example.admin.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String tag = "EVH_demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Log.d(tag, tag + " onCreate() at: " + currentDateTimeString);


    }

    protected void onStart() {
        super.onStart();

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Log.d(tag, tag + " onStart() at: " + currentDateTimeString);
    }

    protected void onRestart() {
        super.onRestart();
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Log.d(tag, tag + " onRestart() at: " + currentDateTimeString);
    }
    protected void onResume() {
        super.onResume();
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Log.d(tag, tag + " onResume() at: " + currentDateTimeString);
    }
    protected void onPause() {
        super.onPause();
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Log.d(tag, tag + " onPause() at: " + currentDateTimeString);
    }
    protected void onStop() {
        super.onStop();
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Log.d(tag, tag + " onStop() at: " + currentDateTimeString);
    }

    protected void onDestroy() {
        super.onDestroy();
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Log.d(tag, tag + " onDestroy() at: " + currentDateTimeString);
    }
}
