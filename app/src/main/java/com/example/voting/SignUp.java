package com.example.voting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class SignUp extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup radioGroup;
    String gender;
    Button button;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        radioGroup = (RadioGroup) findViewById(R.id.gender_group);
        radioGroup.setOnCheckedChangeListener(this);
        button = (Button) findViewById(R.id.nextforcameraoption);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,SignUpForCamera.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        switch(i) {

            case R.id.radiobutton_female:
                gender="Female";
                break;

            case R.id.radiobutton_male:
                gender="Male";
                break;
        }


    }

}