package com.example.practiceapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class QuestionsActivity extends AppCompatActivity {
    private static final String[] COURSE = {"Geography", "Classics"};

    private int courseCode = 0;
    private int numQuestions;
    private float score;
    private float passingGrade;
    private DbHelper dbHelper = new DbHelper(this);
    private SQLiteDatabase db = dbHelper.getWritableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        courseCode = intent.getIntExtra("quiz", -1);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Next questions", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        SQLiteDatabase dbRead = dbHelper.getReadableDatabase();

    }

    private void SaveScore () {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("CID", courseCode);
        values.put("Score", score);
        values.put("Date", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert("Quizzes", null, values);
    }
}
