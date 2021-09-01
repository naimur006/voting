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
    ImageView imageView;
    Button btnopen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageView = findViewById(R.id.image_view);
        btnopen = findViewById(R.id.btn_open);
        radioGroup = (RadioGroup) findViewById(R.id.gender_group);
        radioGroup.setOnCheckedChangeListener(this);

        //Request for Camera permission
        if (ContextCompat.checkSelfPermission(SignUp.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(SignUp.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }
        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            //Get Capture Image
            Bitmap captureimage = (Bitmap) data.getExtras().get("data");
            //Set capture image to imageview
            imageView.setImageBitmap(captureimage);
        }
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