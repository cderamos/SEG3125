package com.example.practiceapp;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int minGrade = 50;
    int numQuestions = 20;
    private ArrayList<Score> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        Toolbar toolbar = findViewById(R.id.toolbarWelcome);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        minGrade = intent.getIntExtra("MinGrade", 50);
        numQuestions = intent.getIntExtra("NumQuestions", 20);
        Bundle args = (Bundle) intent.getBundleExtra("history");
        if (args != null)
            history = (ArrayList<Score>) args.getSerializable("ARRAYLIST");

        Log.d("main: ", minGrade + "  " + numQuestions);
    }

    public void loadGeography(View v) {
        Intent intent = new Intent(this, QuestionsActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)history);
        intent.putExtra("BUNDLE",args);
        intent.putExtra("quiz", 0);
        intent.putExtra("MinGrade", minGrade);
        intent.putExtra("NumQuestions", numQuestions);
        startActivity(intent);
    }

    public void loadClassics(View v) {
        Intent intent = new Intent(this, QuestionsActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)history);
        intent.putExtra("BUNDLE",args);
        intent.putExtra("quiz", 1);
        intent.putExtra("MinGrade", minGrade);
        intent.putExtra("NumQuestions", numQuestions);
        startActivity(intent);
    }

    public void loadSettings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)history);
        intent.putExtra("BUNDLE",args);
        intent.putExtra("quiz", 1);
        intent.putExtra("MinGrade", minGrade);
        intent.putExtra("NumQuestions", numQuestions);
        startActivity(intent);
    }

    public void loadExamHistory(View v) {
        Intent intent = new Intent(this,ExamResultsActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)history);
        intent.putExtra("BUNDLE",args);
        intent.putExtra("quiz", 1);
        intent.putExtra("MinGrade", minGrade);
        intent.putExtra("NumQuestions", numQuestions);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("MinGrade", minGrade);
            intent.putExtra("NumQuestions", numQuestions);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
