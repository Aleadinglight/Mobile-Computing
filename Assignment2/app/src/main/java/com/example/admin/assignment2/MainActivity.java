package com.example.admin.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String tag = "EVH_demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, tag + "onCreate()");
    }

    protected void onStart() {
        super.onStart();
        Log.d(tag, tag + "onStart()");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(tag, tag + "onReStart()");
    }
    protected void onResume() {
        super.onResume();
        Log.d(tag, tag + "onResume()");
    }
    protected void onPause() {
        super.onPause();
        Log.d(tag, tag + "onPause()");
    }
    protected void onStop() {
        super.onStop();
        Log.d(tag, tag + "onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, tag + "onDestroy()");
    }
}
