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
    private Button cos, sin, tan;
    private EditText textField;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cos = findViewById(R.id.cos);
        sin = findViewById(R.id.sin);
        tan = findViewById(R.id.tan);
        textField = findViewById(R.id.textField);
        output = findViewById(R.id.output);

            cos.setOnClickListener(listener);
            sin.setOnClickListener(listener);
            tan.setOnClickListener(listener);

    }

    private Button.OnClickListener listener =
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
}
