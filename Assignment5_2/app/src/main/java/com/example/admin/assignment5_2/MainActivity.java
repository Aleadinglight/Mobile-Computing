package com.example.admin.assignment5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private LinearLayout appLayout;
    private LayoutParams viewLayoutParams;
    private Button button1;
    private Button button2;
    private Button button3;
    private TextView usernameLabel;
    private EditText usernameEdit;
    private TextView passwordLabel;
    private EditText passwordEdit;
    private TextView summary;
    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        viewLayoutParams.leftMargin = 20;
        viewLayoutParams.rightMargin = 20;
        viewLayoutParams.topMargin = 20;

        appLayout = new LinearLayout(this);
        appLayout.setOrientation(LinearLayout.VERTICAL);

        addUsernameField();
        hideUsernameField();

        addPasswordField();
        hidePasswordField();

        addSummary();
        hideSummary();

        addButton();

        this.addContentView(appLayout, viewLayoutParams);
        changeState(state);
    }

    private void addUsernameField() {
        usernameLabel = new TextView(this);
        usernameLabel.setText("Username");
        //usernameLabel.setLayoutParams(viewLayoutParams);

        usernameEdit = new EditText(this);
        //usernameEdit.setLayoutParams(viewLayoutParams);

        appLayout.addView(usernameLabel);
        appLayout.addView(usernameEdit);
    }

    private void addPasswordField() {
        passwordLabel = new TextView(this);
        passwordLabel.setText("Password");
        //usernameLabel.setLayoutParams(viewLayoutParams);

        passwordEdit = new EditText(this);
        passwordEdit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //usernameEdit.setLayoutParams(viewLayoutParams);

        appLayout.addView(passwordLabel);
        appLayout.addView(passwordEdit);
    }

    private void addSummary() {
        summary = new TextView(this);

        appLayout.addView(summary);
    }

    private void addButton() {
        LinearLayout buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Button
        button1 = new Button(this);
        button1.setText("Back to previous");
        button1.setLayoutParams(viewLayoutParams);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(--state);
            }
        });

        // Button
        button2 = new Button(this);
        button2.setText("Continue");
        button2.setLayoutParams(viewLayoutParams);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextState(state);
            }
        });

        // Button
        button3 = new Button(this);
        button3.setText("Reset");
        button3.setLayoutParams(viewLayoutParams);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 0;
                resetAll();
                changeState(state);
            }
        });

        // Add buttons to layout
        buttonLayout.addView(button1);
        buttonLayout.addView(button2);
        buttonLayout.addView(button3);

        appLayout.addView(buttonLayout);
    }

    private void showUsernameField() {
        usernameLabel.setVisibility(TextView.VISIBLE);
        usernameEdit.setVisibility(TextView.VISIBLE);
        usernameEdit.setBackgroundResource(R.drawable.normal_border);
    }

    private void hideUsernameField() {
        usernameLabel.setVisibility(TextView.GONE);
        usernameEdit.setVisibility(TextView.GONE);
    }

    private void showPasswordField() {
        passwordEdit.setVisibility(TextView.VISIBLE);
        passwordLabel.setVisibility(TextView.VISIBLE);
        passwordEdit.setBackgroundResource(R.drawable.normal_border);
    }

    private void hidePasswordField() {
        passwordEdit.setVisibility(TextView.GONE);
        passwordLabel.setVisibility(TextView.GONE);
    }

    private void showSummary() {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String all = "Username: "+ usernameEdit.getText()+ "\n"
                    +"Password: "+ passwordEdit.getText()+ "\n"
                    +"at "+currentDateTimeString;
        summary.setText(all);
        summary.setVisibility(TextView.VISIBLE);
    }

    private void hideSummary() {
        summary.setVisibility(TextView.GONE);
    }

    private void nextState(int state) {
        if ((state == 0) && (TextUtils.isEmpty(usernameEdit.getText().toString())) ) {
                usernameEdit.setBackgroundResource(R.drawable.invalid_border);
                return;
        }

        if ((state == 1) && (TextUtils.isEmpty(passwordEdit.getText().toString())) ){
                passwordEdit.setBackgroundResource(R.drawable.invalid_border);
                return;
        }
        changeState(++this.state);
    }

    private void changeState(int state) {
        Log.d("sadState", ""+state);
        if (state == 0) {
            button1.setVisibility(Button.INVISIBLE);
            button2.setVisibility(Button.VISIBLE);
            showUsernameField();
            hidePasswordField();
            hideSummary();
        }
        else if (state == 1) {
            button1.setVisibility(Button.VISIBLE);
            button2.setVisibility(Button.VISIBLE);
            hideUsernameField();
            showPasswordField();
            hideSummary();
        }
        else if (state == 2) {
            button1.setVisibility(Button.VISIBLE);
            button2.setVisibility(Button.INVISIBLE);
            hideUsernameField();
            hidePasswordField();
            showSummary();
        }
    }

    private void resetAll(){
        usernameEdit.setText("");
        passwordEdit.setText("");
        summary.setText("");
    }
}
