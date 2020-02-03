package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ResultsActivity extends AppCompatActivity {
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        RatingBar rBar = (RatingBar) findViewById(R.id.ratingBar);
        TextView resultText = (TextView) findViewById((R.id.testResultText));
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        score = (int) intent.getIntExtra("score", 0);
        ((TextView) findViewById(R.id.score)).setText(score+"%");
        if (score >=0 && score < 50){
            rBar.setRating((0));
            resultText.setText("Could be better. Need to study more!");
        } if (score >=50 && score <55 ) {
            rBar.setRating(0.5f);
            resultText.setText("Here, half a star is better than nothing. Decent work.");
        } if (score >=55 && score <60) {
            rBar.setRating(1);
            resultText.setText("Good job! A full star");
        } if (score >=60 && score <65){
            rBar.setRating(1.5f);
            resultText.setText("You know what they say, practice makes perfect");
        } if (score >=65 && score <70) {
            rBar.setRating((2));
            resultText.setText("You know what they say, practice makes perfect");
        } if(score >=70 && score <75){
            rBar.setRating((2.5f));
            resultText.setText("There's still room for improvement, but good job!");
        } if(score >=75 && score <80) {
            rBar.setRating((3));
            resultText.setText("There's still room for improvement, but good job!");
        } if(score >=80 && score <85){
            rBar.setRating((3.5f));
            resultText.setText("Good job!");
        } if(score >=85 && score <90) {
            rBar.setRating((4));
            resultText.setText("Good job!");
        } if(score >=90 && score <95) {
            rBar.setRating((4.5f));
            resultText.setText("Good job!");
        } if(score >=95 && score <100) {
            rBar.setRating((5));
            resultText.setText("You did it! 5 stars!");
        }

        ((TextView) findViewById(R.id.date)).setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
