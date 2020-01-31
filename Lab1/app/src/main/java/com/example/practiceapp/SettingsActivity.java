package com.example.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceFragmentCompat;

import java.text.ParseException;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public void apply(View v) {
        int minGrade = 0;
        EditText minText = (EditText) findViewById(R.id.minGrade);
        try {
            minGrade = Integer.parseInt(minText.getText().toString());
        } catch (Exception e) {
            // Error here
        }

        Log.d("Min", ""+minGrade);
    }
}