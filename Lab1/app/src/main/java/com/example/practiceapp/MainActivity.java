package com.example.practiceapp;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        Toolbar toolbar = findViewById(R.id.toolbarWelcome);
        setSupportActionBar(toolbar);
    }

    public void loadGeography(View v) {
        Intent intent = new Intent(this, QuestionsActivity.class);
        intent.putExtra("quiz", 0);
        startActivity(intent);
    }

    public void loadClassics(View v) {
        Intent intent = new Intent(this, QuestionsActivity.class);
        intent.putExtra("quiz", 1);
        startActivity(intent);
    }

    public void loadSettings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void loadExamHistory(View v) {
        Intent intent = new Intent(this,ExamResultsActivity.class);
        intent.putExtra("results", 2);
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
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
