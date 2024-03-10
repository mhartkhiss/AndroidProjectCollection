package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ButtonExercise extends AppCompatActivity {


    Button btn1, btn2, btn3, btn4, btn5, btn6;
    ConstraintLayout activityButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        btn1 = (Button) findViewById(R.id.btnOpen);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ButtonExercise.this,ReturnActivity.class);
                startActivity(intent1);
            }
        });
        btn2 = (Button) findViewById(R.id.btnToast);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercise.this, "Hi! This is Toast. Activity 2 Button!", Toast.LENGTH_SHORT).show();
            }
        });

        btn3 = (Button) findViewById(R.id.btnChangeBG);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityButtons = findViewById(R.id.buttonExerciseLayout);
                activityButtons.setBackgroundColor(Color.BLUE);
            }
        });

        btn4 = (Button) findViewById(R.id.btnChangeButtonBG);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4.setBackgroundColor(Color.RED);
            }
        });
        btn5 = (Button) findViewById(R.id.btnDisappear);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5.setVisibility(View.INVISIBLE);
            }
        });
    }
}