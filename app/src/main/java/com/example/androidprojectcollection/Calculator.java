package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator extends AppCompatActivity {

    private TextView displayNum;
    private Double tempResult = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        displayNum = findViewById(R.id.displayNum);

        // Find all buttons
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.btnMidterm);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);
        Button buttonClear = findViewById(R.id.buttonClear);

        // Set click listeners for all buttons
        button0.setOnClickListener(buttonClickListener);
        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);
        button4.setOnClickListener(buttonClickListener);
        button5.setOnClickListener(buttonClickListener);
        button6.setOnClickListener(buttonClickListener);
        button7.setOnClickListener(buttonClickListener);
        button8.setOnClickListener(buttonClickListener);
        button9.setOnClickListener(buttonClickListener);
        buttonDot.setOnClickListener(buttonClickListener);
        buttonAdd.setOnClickListener(buttonClickListener);
        buttonSubtract.setOnClickListener(buttonClickListener);
        buttonMultiply.setOnClickListener(buttonClickListener);
        buttonDivide.setOnClickListener(buttonClickListener);
        buttonEquals.setOnClickListener(buttonClickListener);
        buttonClear.setOnClickListener(buttonClickListener);
    }
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String buttonText = ((Button) view).getText().toString();
            String operators = "+-×÷";
            String displayText = displayNum.getText().toString();
            String lastInput = displayText.substring(displayText.length() - 1);

            if(operators.contains(lastInput) && operators.contains(buttonText))
            {
                displayNum.setText(displayText.substring(0, displayText.length() - 1) + buttonText);
                tempResult = Double.parseDouble(displayText.substring(0, displayText.length() - 1));
                return;
            }

            if(buttonText.equals(".") && lastInput.equals("."))
            {
                return;
            }

            if (buttonText.equals("C")) {
                displayNum.setText("0");
                return;
            }

            if (buttonText.equals("=")) {
                double result = evaluateExpression(displayText);
                if (result == (int) result) {
                    displayNum.setText(String.valueOf((int) result));
                } else {
                    displayNum.setText(String.valueOf(result));
                }
                return;
            }

            if (displayText.equals("0")) {
                displayNum.setText(buttonText);
            } else {
                displayNum.append(buttonText);
            }
        }
    };

    private double evaluateExpression(String expression) {
        expression = expression.replaceFirst("^0+(?!$)", "");

        expression = expression.replaceAll("÷", "/").replaceAll("×", "*");

        ExpressionBuilder builder = new ExpressionBuilder(expression);
        Expression expr = builder.build();
        double result = expr.evaluate();

        return result;
    }



}

