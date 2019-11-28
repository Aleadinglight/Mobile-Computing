package com.example.admin.assignment4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnCurrent = (Button) findViewById(R.id.button_current);
        Button btnClear = (Button) findViewById(R.id.button_clear);
        final TextView textView = (TextView) findViewById(R.id.text_datetime);

        btnCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                textView.setText(currentDateTimeString);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });

    }
}
