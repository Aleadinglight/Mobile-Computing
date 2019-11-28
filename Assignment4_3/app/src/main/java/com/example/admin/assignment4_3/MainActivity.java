package com.example.admin.assignment4_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String expression = "";
    private String result = "";

    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnModulo;
    private Button btnDelete;
    private Button btnInvert;
    private String btnSentinel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlus = (Button) findViewById(R.id.button_plus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPressPlus();
            }
        });

        btnMinus = (Button) findViewById(R.id.button_minus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPressMinus();
            }
        });

        btnMultiply = (Button) findViewById(R.id.button_multiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPressMultiply();
            }
        });

        btnDivide = (Button) findViewById(R.id.button_divide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPressDivide();
            }
        });

        btnModulo = (Button) findViewById(R.id.button_modulo);
        btnModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPressModulo();
            }
        });

        btnDelete = (Button) findViewById(R.id.button_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPressDelete();
            }
        });
    }
}
