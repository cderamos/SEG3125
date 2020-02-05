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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ResultsActivity extends AppCompatActivity {
    private int minGrade = 0;
    private int numQuestions = 20;
    private int score = 0;
    private String title = null;
    private ArrayList<Score> history = new ArrayList<>();
    private String category = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        RatingBar rBar = (RatingBar) findViewById(R.id.ratingBar);
        TextView resultText = (TextView) findViewById((R.id.testResultText));
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        minGrade = intent.getIntExtra("MinGrade", 50);
        numQuestions = intent.getIntExtra("NumQuestions", 20);
        score = (int) intent.getIntExtra("score", 0);
        title =  intent.getStringExtra("title");
        Bundle args = (Bundle) intent.getBundleExtra("history");
        if (args != null)
            history = (ArrayList<Score>) args.getSerializable("ARRAYLIST");
        history.add(new Score(score, title, new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date())));

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
        } if(score >=95 && score <=100) {
            rBar.setRating((5));
            resultText.setText("You did it! 5 stars!");
        }

        if (score > minGrade) {
            ((TextView) findViewById(R.id.minGrade)).setText("Congradulations! You passed the minimum grade of " + minGrade + "%");
        } else if (score == minGrade) {
            ((TextView) findViewById(R.id.minGrade)).setText("You barely passed the minimum grade of " + minGrade + "%");
        } else {
            ((TextView) findViewById(R.id.minGrade)).setText("Sorry! You failed the exam. The minimum grade was " + minGrade + "%");
        }

        ((TextView) findViewById(R.id.date)).setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",history);
        intent.putExtra("BUNDLE", args);
        intent.putExtra("MinGrade", minGrade);
        intent.putExtra("NumQuestions", numQuestions);
        startActivity(intent);
    }
}
