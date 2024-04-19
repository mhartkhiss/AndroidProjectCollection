package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PassingIntentsExercise extends AppCompatActivity {

    Button btnSubmit, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);

            EditText editTextFirstName = findViewById(R.id.editTextFirstName);
            EditText editTextLastName = findViewById(R.id.editTextLastName);
            RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
            EditText editBirthDate = findViewById(R.id.editBirthDate);
            EditText editPhoneNumber = findViewById(R.id.editPhoneNumber);
            EditText editEmail = findViewById(R.id.editEmail);
            EditText editCourse = findViewById(R.id.editCourse);
            EditText editYearLevel = findViewById(R.id.editYearLevel);
            EditText editCity = findViewById(R.id.editCity);
            EditText editAddress = findViewById(R.id.editAddress);
            EditText editPostalCode = findViewById(R.id.editPostalCode);

            intent.putExtra("firstName", editTextFirstName.getText().toString());
            intent.putExtra("lastName", editTextLastName.getText().toString());
            intent.putExtra("gender", ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString());
            intent.putExtra("birthDate", editBirthDate.getText().toString());
            intent.putExtra("phoneNumber", editPhoneNumber.getText().toString());
            intent.putExtra("email", editEmail.getText().toString());
            intent.putExtra("course", editCourse.getText().toString());
            intent.putExtra("yearLevel", editYearLevel.getText().toString());
            intent.putExtra("city", editCity.getText().toString());
            intent.putExtra("address", editAddress.getText().toString());
            intent.putExtra("postalCode", editPostalCode.getText().toString());

            startActivity(intent);
        });

        btnClear = (Button) findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(v -> {
            EditText editTextFirstName = findViewById(R.id.editTextFirstName);
            EditText editTextLastName = findViewById(R.id.editTextLastName);
            RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
            EditText editBirthDate = findViewById(R.id.editBirthDate);
            EditText editPhoneNumber = findViewById(R.id.editPhoneNumber);
            EditText editEmail = findViewById(R.id.editEmail);
            EditText editCourse = findViewById(R.id.editCourse);
            EditText editYearLevel = findViewById(R.id.editYearLevel);
            EditText editCity = findViewById(R.id.editCity);
            EditText editAddress = findViewById(R.id.editAddress);
            EditText editPostalCode = findViewById(R.id.editPostalCode);

            editTextFirstName.setText("");
            editTextLastName.setText("");
            radioGroupGender.clearCheck();
            editBirthDate.setText("");
            editPhoneNumber.setText("");
            editEmail.setText("");
            editCourse.setText("");
            editYearLevel.setText("");
            editCity.setText("");
            editAddress.setText("");
            editPostalCode.setText("");
        });


    }
}