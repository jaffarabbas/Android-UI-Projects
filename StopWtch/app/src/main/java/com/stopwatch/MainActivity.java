package com.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView quote,SubQuote;
    Button getIntoWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quote = (TextView) findViewById(R.id.quote);
        SubQuote = (TextView) findViewById(R.id.subquaote);
        getIntoWatch = (Button) findViewById(R.id.intostopwatch);

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