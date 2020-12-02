package com.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView quote,SubQuote;
    Button getIntoWatch;
    Animation atg,BtgOne,BtgTwo;
    ImageView bgImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quote = (TextView) findViewById(R.id.quote);
        SubQuote = (TextView) findViewById(R.id.subquaote);
        getIntoWatch = (Button) findViewById(R.id.intostopwatch);
        bgImage = (ImageView) findViewById(R.id.bgImage);
        //Load Animation
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        BtgOne = AnimationUtils.loadAnimation(this,R.anim.btgone);
        BtgTwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);
        //passing Animation
        bgImage.startAnimation(atg);
        quote.startAnimation(BtgOne);
        SubQuote.startAnimation(BtgOne);
        getIntoWatch.startAnimation(BtgTwo);

        //Into stop watch
        this.getIntoWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StopWatch.class);
                intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        //import fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");
        //customize font
        quote.setTypeface(MRegular);
        SubQuote.setTypeface(MLight);
        getIntoWatch.setTypeface(MMedium);
    }
}