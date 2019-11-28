package com.example.admin.assignment4_2;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText inputName;
    private EditText inputComment;
    private Button btnSubmit;
    private TextView info;
    private String previousInfo = "";
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = (EditText) findViewById(R.id.input_name);
        inputComment = (EditText) findViewById(R.id.input_comment);
        btnSubmit = (Button) findViewById(R.id.button_submit);
        info = (TextView) findViewById(R.id.text_history);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    private void submit() {
        boolean check = true;
        String name = inputName.getText().toString();
        String comment = inputComment.getText().toString();

        if (TextUtils.isEmpty(name)){
            info.setTextColor(Color.RED);
            info.setText("Invalid input. You need to fill out all fields.");
            check = false;
        }
        if (TextUtils.isEmpty(comment)){
            info.setTextColor(Color.RED);
            info.setText("Invalid input. You need to fill out all fields.");
            check = false;
        }

        if (check) {
            id+=1;
            info.setTextColor(Color.BLACK);
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

            String newInfo = id+". ";
            newInfo += "Date: " + currentDateTimeString + "\n";
            newInfo += "Name: " + name + "\n";
            newInfo += "Comment: " + comment + "\n\n";

            previousInfo += newInfo;
            info.setText(previousInfo);
        }
    }
}
