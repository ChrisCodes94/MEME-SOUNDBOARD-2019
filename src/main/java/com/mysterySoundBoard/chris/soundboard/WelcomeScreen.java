package com.mysterySoundBoard.chris.soundboard;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class WelcomeScreen extends Activity {


    private final static int SPLASH_TIME_OUT= 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent spalsh = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(spalsh);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
