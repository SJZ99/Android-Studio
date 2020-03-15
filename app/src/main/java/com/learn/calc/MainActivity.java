package com.learn.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button cos, sin, tan, cos_rad, sin_rad, tan_rad;
    private EditText textField;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cos = findViewById(R.id.cos);
        sin = findViewById(R.id.sin);
        tan = findViewById(R.id.tan);

        cos_rad = findViewById(R.id.cos_Rad);
        sin_rad = findViewById(R.id.sin_Rad);
        tan_rad = findViewById(R.id.tan_Rad);

        textField = findViewById(R.id.textField);
        output = findViewById(R.id.output);

        cos.setOnClickListener(degree);
        sin.setOnClickListener(degree);
        tan.setOnClickListener(degree);

        cos_rad.setOnClickListener(radium);
        sin_rad.setOnClickListener(radium);
        tan_rad.setOnClickListener(radium);

    }

    private Button.OnClickListener degree =
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    double input = 0;
                    try {
                        input = Double.parseDouble(textField.getText().toString());
                        switch (v.getId()) {
                            case R.id.cos: {
                                output.setText("Cos(" + input + ") = " + Math.cos(Math.toRadians(input)));
                                break;
                            }
                            case R.id.sin: {
                                output.setText("Sin(" + input + ") = " + Math.sin(Math.toRadians(input)));
                                break;
                            }
                            case R.id.tan: {
                                output.setText("Tan(" + input + ") = " + Math.tan(Math.toRadians(input)));
                                break;
                            }
                        }
                    }catch(RuntimeException e){
                        output.setText("請輸入要轉換的角度");
                    }
                }
            };
    private Button.OnClickListener radium =
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    double input = 0;
                    try {
                        input = Double.parseDouble(textField.getText().toString());
                        switch (v.getId()) {
                            case R.id.cos_Rad: {
                                output.setText("Cos_Rad(" + input + ") = " + Math.cos((input)));
                                break;
                            }
                            case R.id.sin_Rad: {
                                output.setText("Sin_Rad(" + input + ") = " + Math.sin((input)));
                                break;
                            }
                            case R.id.tan_Rad: {
                                output.setText("Tan_Rad(" + input + ") = " + Math.tan((input)));
                                break;
                            }
                        }
                    }catch(RuntimeException e){
                        output.setText("請輸入要轉換的弳度");
                    }
                }
            };
}
