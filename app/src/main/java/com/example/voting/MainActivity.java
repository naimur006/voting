package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;

    //Variables
    Animation topanim, bottomanim;
    TextView text1, text2, text3, text4;
    ImageView image1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        //Hooks
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        image1 = findViewById(R.id.image1);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);


        text1.setAnimation(topanim);
        text2.setAnimation(topanim);
        image1.setAnimation(topanim);
        text3.setAnimation(bottomanim);
        text4.setAnimation(bottomanim);



        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);





    }
}