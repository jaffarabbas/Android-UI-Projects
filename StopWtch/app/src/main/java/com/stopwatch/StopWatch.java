package com.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {
    Button btnStart,btnStop;
    ImageView Routater;
    Animation rounding;
    Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_watch);

        btnStart = (Button) findViewById(R.id.StartWatch);
        btnStop = (Button) findViewById(R.id.StopWatch);
        Routater = (ImageView) findViewById(R.id.WatchScroller);

        //timer
        timer = (Chronometer) findViewById(R.id.timer);

        //Load Animations
        rounding = AnimationUtils.loadAnimation(this,R.anim.routate);
        //Animations
        btnStop.setAlpha(0);
        //Rounding of watch
        this.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Routater.startAnimation(rounding);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();
                //start time
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
        //stop watch
        this.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                btnStart.animate().alpha(1).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();
            }
        });
        //import fonts
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        //customize font
        btnStart.setTypeface(MMedium);
    }
}