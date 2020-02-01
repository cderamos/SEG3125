package com.example.practiceapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import androidx.core.content.ContextCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private DbHelper dbHelper = new DbHelper(this);
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        db = dbHelper.getWritableDatabase();
        setContentView(R.layout.settings_screen);
        final Toolbar toolbar = findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = toolbar.getChildAt(0);
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });
    }

    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d("okk", "ok: " + id);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void apply(View v) {
        float minGrade = 0;
        int numQuestions = 20;
        EditText minText = (EditText) findViewById(R.id.minGrade);
        try {
            minGrade = Integer.parseInt(minText.getText().toString())/100;

            ContentValues values = new ContentValues();
            values.put("MinGrade", minGrade);
            values.put("NumQuestions", numQuestions);

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert("Quizzes", null, values);
        } catch (Exception e) {
            // Error here
        }
    }
}