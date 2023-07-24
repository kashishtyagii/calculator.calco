package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc extends AppCompatActivity {

    private EditText editTextText2, editTextText3;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
        textViewResult = findViewById(R.id.textView3);

        Button buttonAdd = findViewById(R.id.button2);
        Button buttonSubtract = findViewById(R.id.button3);
        Button buttonMultiply = findViewById(R.id.button4);
        Button buttonDivide = findViewById(R.id.button5);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult("add");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult("subtract");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult("multiply");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult("divide");
            }
        });
    }

    private void calculateResult(String operation) {
        double num1 = Double.parseDouble(editTextText2.getText().toString());
        double num2 = Double.parseDouble(editTextText3.getText().toString());
        double result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textViewResult.setText("Cannot divide by zero!");
                    return;
                }
                break;
        }

        textViewResult.setText("Result: " + result);
    }
}
