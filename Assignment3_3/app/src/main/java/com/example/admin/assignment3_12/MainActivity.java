package com.example.admin.assignment3_12;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private String appTag = "app312";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(appTag, "Created.");
        if(savedInstanceState!=null)
            onRestoreInstanceState(savedInstanceState);
    }
}
