package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class SignUp extends AppCompatActivity {

    EditText name, phoneNo;
    Spinner gender;
    Switch phoneVisibility;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.edit_text_name);
        phoneNo = findViewById(R.id.edit_phone);
        gender = findViewById(R.id.spinner_gender);
        phoneVisibility = findViewById(R.id.switch_phone_visibility);
        age = findViewById(R.id.edit_text_age);
    }

    public void SignUpAccount(View view)
    {

    }
}