package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Match3 extends AppCompatActivity {
    Button[] btn = new Button[25];
    String[] btnColor = new String[25];

    String previousBtnColor = "";
    String currentBtnColor = "";
    Button previousBtn = null, btnRestart, currentBtn = null;
    TextView textScore;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);

        btnRestart = findViewById(R.id.btnRestart);
        textScore = findViewById(R.id.textScore);
        textScore.setText("Score: " + score);

        btnRestart.setOnClickListener(v -> {
            finish();
            startActivity(getIntent());
        });

        for (int i = 0; i < 25; i++) {
            btn[i] = findViewById(getResources().getIdentifier("btn" + (i + 1), "id", getPackageName()));
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    btn[i].setBackgroundColor(getResources().getColor(R.color.red));
                    btnColor[i] = "#DA4949";
                    break;
                case 1:
                    btn[i].setBackgroundColor(getResources().getColor(R.color.green));
                    btnColor[i] = "#4CAF50";
                    break;
                case 2:
                    btn[i].setBackgroundColor(getResources().getColor(R.color.blue));
                    btnColor[i] = "#2196F3";
                    break;
                case 3:
                    btn[i].setBackgroundColor(getResources().getColor(R.color.yellow));
                    btnColor[i] = "#FFFFEB3B";
                    break;
            }
            final int finalI = i;
            btn[i].setOnClickListener(v -> {

                Button clickedButton = (Button) v;

                if (previousBtn == null) {
                    previousBtn = (Button) v;
                    previousBtnColor = btnColor[finalI];

                    previousBtn.setText("*");
                    previousBtn.setTextColor(0xFF000000);
                } else if (currentBtn == null && isAdjacent(previousBtn, (Button) v)) {
                    currentBtn = (Button) v;
                    currentBtnColor = btnColor[finalI];
                    swapColors(previousBtn, currentBtn, previousBtnColor, currentBtnColor);
                    previousBtn.setText("");
                    currentBtn.setText("");
                    checkMatches();
                    previousBtn = null;
                    currentBtn = null;
                }
            });
        }
    }



    private void swapColors(Button btn1, Button btn2, String color1, String color2) {
        btn1.setBackgroundColor(Color.parseColor(color2));
        btn2.setBackgroundColor(Color.parseColor(color1));
        btnColor[getIndex(btn1)] = color2;
        btnColor[getIndex(btn2)] = color1;
    }

    private int getIndex(Button btn) {
        for (int i = 0; i < 25; i++) {
            if (btn.getId() == this.btn[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    private void checkMatches() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                String color1 = btnColor[row * 5 + col];
                String color2 = btnColor[row * 5 + col + 1];
                String color3 = btnColor[row * 5 + col + 2];
                if (color1.equals(color2) && color2.equals(color3)) {
                    final int finalRow = row;
                    final int finalCol = col;
                    btn[row * 5 + col].setText("M");
                    btn[row * 5 + col + 1].setText("M");
                    btn[row * 5 + col + 2].setText("M");
                    btn[row * 5 + col].setTextColor(0xFF000000);
                    btn[row * 5 + col + 1].setTextColor(0xFF000000);
                    btn[row * 5 + col + 2].setTextColor(0xFF000000);
                    new Handler().postDelayed(() -> {
                        btn[finalRow * 5 + finalCol].setText("");
                        btn[finalRow * 5 + finalCol + 1].setText("");
                        btn[finalRow * 5 + finalCol + 2].setText("");
                        replaceTiles(finalRow * 5 + finalCol, finalRow * 5 + finalCol + 1, finalRow * 5 + finalCol + 2);
                        checkMatches();
                        score++;
                        updateScoreTextView();
                    }, 2000);
                    return;
                }
            }
        }

        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 3; row++) {
                String color1 = btnColor[row * 5 + col];
                String color2 = btnColor[(row + 1) * 5 + col];
                String color3 = btnColor[(row + 2) * 5 + col];
                if (color1.equals(color2) && color2.equals(color3)) {
                    final int finalRow = row;
                    final int finalCol = col;
                    btn[row * 5 + col].setText("M");
                    btn[(row + 1) * 5 + col].setText("M");
                    btn[(row + 2) * 5 + col].setText("M");
                    btn[row * 5 + col].setTextColor(0xFF000000);
                    btn[(row + 1) * 5 + col].setTextColor(0xFF000000);
                    btn[(row + 2) * 5 + col].setTextColor(0xFF000000);
                    new Handler().postDelayed(() -> {
                        btn[finalRow * 5 + finalCol].setText("");
                        btn[(finalRow + 1) * 5 + finalCol].setText("");
                        btn[(finalRow + 2) * 5 + finalCol].setText("");
                        replaceTiles(finalRow * 5 + finalCol, (finalRow + 1) * 5 + finalCol, (finalRow + 2) * 5 + finalCol);
                        checkMatches();
                        score++;
                        updateScoreTextView();
                    }, 2000);
                    return;
                }
            }
        }
    }



    private void replaceTiles(int index1, int index2, int index3) {
        btnColor[index1] = getRandomColor();
        btnColor[index2] = getRandomColor();
        btnColor[index3] = getRandomColor();

        btn[index1].setBackgroundColor(Color.parseColor(btnColor[index1]));
        btn[index2].setBackgroundColor(Color.parseColor(btnColor[index2]));
        btn[index3].setBackgroundColor(Color.parseColor(btnColor[index3]));
    }

    private String getRandomColor() {
        int random = (int) (Math.random() * 4);
        switch (random) {
            case 0:
                return "#DA4949"; // Red
            case 1:
                return "#4CAF50"; // Green
            case 2:
                return "#2196F3"; // Blue
            case 3:
                return "#FFFFEB3B"; // Yellow
            default:
                return "#FFFFFF";
        }
    }

    private void updateScoreTextView() {
        textScore.setText("Score: " + score);
    }

    private boolean isAdjacent(Button btn1, Button btn2) {
        int index1 = getIndex(btn1);
        int index2 = getIndex(btn2);
        int row1 = index1 / 5;
        int col1 = index1 % 5;
        int row2 = index2 / 5;
        int col2 = index2 % 5;
        return (Math.abs(row1 - row2) == 1 && col1 == col2) || (Math.abs(col1 - col2) == 1 && row1 == row2);
    }


}
