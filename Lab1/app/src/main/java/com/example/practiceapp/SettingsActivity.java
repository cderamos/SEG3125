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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceFragmentCompat;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {
    private ArrayList<Score> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        final Toolbar toolbar = findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int minGrade = intent.getIntExtra("MinGrade", 50);
        int numQuestions = intent.getIntExtra("NumQuestions", 20);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = toolbar.getChildAt(0);
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });

        //((TextView) findViewById(R.id.minGrade)).setText(minGrade);
        Spinner sp = (Spinner)findViewById(R.id.spinner);
        sp.setSelection(numQuestions-1);
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
        int minGrade = 0;
        int numQuestions = 20;
        EditText minText = (EditText) findViewById(R.id.minGrade);
        try {
            minGrade = Integer.parseInt(minText.getText().toString());
            numQuestions = Integer.parseInt(((Spinner)findViewById(R.id.spinner)).getSelectedItem().toString());

            if (minGrade < 0 || minGrade > 100 || minText.getText().toString().equals(null)) {
                Toast.makeText(SettingsActivity.this, "Please enter a minimum grade between 0% and 100%", Toast.LENGTH_LONG).show();
                return;
            } else {
                Toast.makeText(SettingsActivity.this, "Settings Applied", Toast.LENGTH_LONG).show();
            }
            Log.d("apply: ", minGrade + "  " + numQuestions);

            Intent intent = new Intent(this, MainActivity.class);
            Bundle args = new Bundle();
            args.putSerializable("ARRAYLIST",(Serializable)history);
            intent.putExtra("BUNDLE",args);
            intent.putExtra("MinGrade", minGrade);
            intent.putExtra("NumQuestions", numQuestions);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}