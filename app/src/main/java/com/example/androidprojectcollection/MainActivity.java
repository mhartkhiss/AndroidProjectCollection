package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = (Button) findViewById(R.id.btnLayoutExercise);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,LayoutExercise.class);
                startActivity(intent1);
            }
        });

        btn2 = (Button) findViewById(R.id.btnButtonExercise);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,ButtonExercise.class);
                startActivity(intent2);
            }
        });
        btn3 = (Button) findViewById(R.id.btnCalculator);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,Calculator.class);
                startActivity(intent2);
            }
        });

        btn4 = (Button) findViewById(R.id.btnMidterm);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Match3.class));
                Toast.makeText(MainActivity.this, "Degollacion, Mhart Khiss - Match3", Toast.LENGTH_SHORT).show();
            }
        });

        btn5= (Button) findViewById(R.id.btnMatch3);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Match3.class));
                Toast.makeText(MainActivity.this, "Degollacion, Mhart Khiss - Match3", Toast.LENGTH_SHORT).show();
            }
        });

        btn6 = (Button) findViewById(R.id.btnPassingIntents);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,PassingIntentsExercise.class);
                startActivity(intent2);
            }
        });


    }
}