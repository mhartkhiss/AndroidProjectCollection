package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        Intent intent = getIntent();

        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String gender = intent.getStringExtra("gender");
        String birthDate = intent.getStringExtra("birthDate");
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String email = intent.getStringExtra("email");
        String course = intent.getStringExtra("course");
        String yearLevel = intent.getStringExtra("yearLevel");
        String city = intent.getStringExtra("city");
        String address = intent.getStringExtra("address");
        String postalCode = intent.getStringExtra("postalCode");

        TextView textViewFirstName = findViewById(R.id.textViewFirstName);
        TextView textViewLastName = findViewById(R.id.textViewLastName);
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewBirthDate = findViewById(R.id.textViewBirthDate);
        TextView textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewCourse = findViewById(R.id.textViewCourse);
        TextView textViewYearLevel = findViewById(R.id.textViewYearLevel);
        TextView textViewCity = findViewById(R.id.textViewCity);
        TextView textViewAddress = findViewById(R.id.textViewAddress);
        TextView textViewPostalCode = findViewById(R.id.textViewPostalCode);

        textViewFirstName.setText("First Name: " + firstName);
        textViewLastName.setText("Last Name: " + lastName);
        textViewGender.setText("Gender: " + gender);
        textViewBirthDate.setText("Birth Date: " + birthDate);
        textViewPhoneNumber.setText("Phone Number: " + phoneNumber);
        textViewEmail.setText("Email: " + email);
        textViewCourse.setText("Course: " + course);
        textViewYearLevel.setText("Year Level: " + yearLevel);
        textViewCity.setText("City: " + city);
        textViewAddress.setText("Address: " + address);
        textViewPostalCode.setText("Postal Code: " + postalCode);

        Button buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(v -> {
            finish();
        });
    }
}