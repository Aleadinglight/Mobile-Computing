package com.example.admin.assignment5_1;

import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    private LayoutParams viewLayoutParams;
    private Button button1;
    private Button button2;
    private int minOffset=-1;
    private int maxOffset=-1;
    private int speed= 100;
    private int offset = 20;
    private int dir = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Here we define parameters for views
        viewLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        viewLayoutParams.leftMargin = 20;
        viewLayoutParams.rightMargin = 20;
        viewLayoutParams.topMargin = 20;

        // Layout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Button
        button1 = new Button(this);
        button1.setText("Toggle other button");
        button1.setLayoutParams(viewLayoutParams);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstButtonClicked();
            }
        });

        // Button
        button2 = new Button(this);
        button2.setText("Move other button");
        button2.setLayoutParams(viewLayoutParams);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondButtonClicked();
            }
        });

        // Add buttons to layout
        linearLayout.addView(button1);
        linearLayout.addView(button2);

        LayoutParams linearLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        this.addContentView(linearLayout, linearLayoutParams);
    }

    private void firstButtonClicked() {
        if (button2.isShown()){
            button2.setVisibility(Button.INVISIBLE);
        }
        else {
            button2.setVisibility(Button.VISIBLE);
        }
    }

    private void secondButtonClicked() {
        // Get button y-axis location

        int[] outLocation = new int[2];
        button1.getLocationOnScreen(outLocation);

        // Set minOffset and maxOffset
        if (minOffset < 0 || maxOffset < 0) {
            minOffset = 20;
            maxOffset = Resources.getSystem().getDisplayMetrics().heightPixels - button1.getHeight() - minOffset - outLocation[1];
            Log.d("hp", "minOffset: " + minOffset);
            Log.d("hp", "maxOffset: " + maxOffset);

        }

        offset = offset + dir * speed;
        Log.d("hp", "offset: " + offset);

        if (offset < minOffset || offset > maxOffset) {
            dir = dir * -1;
            offset = offset + 2 * dir * speed;
        }
        moveButton(button1, offset);

    }

    private void moveButton(Button button, int offset) {
        LinearLayout.LayoutParams newParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        newParams.leftMargin = 20;
        newParams.rightMargin = 20;
        newParams.topMargin = offset;

        button.setLayoutParams(newParams);
    }
}
