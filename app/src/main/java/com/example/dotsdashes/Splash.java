package com.example.dotsdashes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    Animation splash,splash1;
    ImageView img;
    TextView tv;
    private static int TIME_OUT = 4500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final MediaPlayer star= MediaPlayer.create(Splash.this , R.raw.start);
        star.start();
        img = findViewById(R.id.imageView);
        tv = findViewById(R.id.textView2);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        splash = AnimationUtils.loadAnimation(this,R.anim.splash);
        splash1 = AnimationUtils.loadAnimation(this,R.anim.splash1);
        img.setAnimation(splash);
        tv.setAnimation(splash1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this , grid.class);
                finish();
                star.stop();
                startActivity(intent);
            }
        },TIME_OUT);
    }
}
