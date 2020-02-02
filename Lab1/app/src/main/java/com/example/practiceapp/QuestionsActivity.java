package com.example.practiceapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QuestionsActivity extends AppCompatActivity {
    private static final String[] COURSE = {"Geography", "Classics"};

    private int courseCode = 0;
    private int rightAnswers = 0;
    private int numQuestions = 3;
    private int currentAnswer = 0;
    private int currentQuestion = -1;
    private float passingGrade;
    private String[] questions = {"What?", "When?", "sjiqwji"};
    private String[][] answers = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
    private DbHelper dbHelper = new DbHelper(this);

    private SQLiteDatabase dbWrite;
    private SQLiteDatabase dbRead;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        courseCode = intent.getIntExtra("quiz", -1);

        // Load db and UI
        dbWrite = dbHelper.getWritableDatabase();
        dbRead = dbHelper.getReadableDatabase();
        loadNextQuestion();

        String json = loadJSONFromAssets();
        Log.d("onCreate: ", " "+json);
        parseJSON(json);
        //loadSettings();
    }

    public void onNextButtonClick(View view) {
        // Get answer


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        if(radioGroup.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getApplicationContext(), "Please select an answer", Toast.LENGTH_SHORT).show();
            Log.d("Ok", "bad");
        }
        else
        {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            // find the radiobutton by returned id
            RadioButton selectedRadioButton = (RadioButton)findViewById(selectedId);

            Log.d("onNextButtonClick: ", currentQuestion + "");
            if (answers[currentQuestion][0] == selectedRadioButton.getText().toString()) {
                rightAnswers++;
                Toast.makeText(getApplicationContext(), "Right answer!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Wrong answer!", Toast.LENGTH_SHORT).show();
            }

            if (currentQuestion < questions.length-1)
                loadNextQuestion();
            else
                quizComplete();
            updateProgressBar();
        }
    }

    private void quizComplete() {
        // Display results
        updateProgressBar(100);
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra("score", (int)(rightAnswers*100)/numQuestions);
        startActivity(intent);
    }

    private void loadNextQuestion() {
        currentQuestion++;

        // Set text answers
        List<String> answerList = new ArrayList<>();
        answerList.add(answers[currentQuestion][0]);
        answerList.add(answers[currentQuestion][1]);
        answerList.add(answers[currentQuestion][2]);
        answerList.add(answers[currentQuestion][3]);

        // Shuffle!
        Collections.shuffle(answerList);
        Log.d("List", answerList.toString());
        currentAnswer = 0;
        for (String curVal : answerList){
            if (curVal.contains(answers[currentQuestion][0])){
                break;
            }
            currentAnswer++;
        }

        // Set UI
        ((TextView) findViewById(R.id.question)).setText(questions[currentQuestion]);
        ((RadioButton) findViewById(R.id.a)).setText(answerList.get(0));
        ((RadioButton) findViewById(R.id.b)).setText(answerList.get(1));
        ((RadioButton) findViewById(R.id.c)).setText(answerList.get(2));
        ((RadioButton) findViewById(R.id.d)).setText(answerList.get(3));
    }

    private void updateProgressBar() {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress((int)(((currentQuestion)*100)/numQuestions));
    }
    private void updateProgressBar(int p) {
        //if (p >= 0 && p <= 100) {
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setProgress(p);
      //  }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseJSON(String json) {

        try {
            //Read JSON file
            JSONObject jsonObject = new JSONObject(json);
            JSONObject q = jsonObject.getJSONObject("questions");
            JSONArray questions = jsonObject.getJSONArray(q.toString());
            Log.d("parseJSON: ", String.valueOf(q));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAssets() {
        String json = null;
        String fn = null;
        if (courseCode == 0)
            fn = "Geography.json";
        else
            fn = "Classics.json";

        try {
            InputStream is = QuestionsActivity.this.getAssets().open(fn);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void loadSettings() {
        Cursor c = dbRead.query("Settings", new String[]{"MinGrade", "NumQuestions"}, null, null, null, null, null);
        passingGrade = c.getColumnIndex("MinGrade");
        numQuestions = c.getColumnIndex("NumQuestions");

        Log.d("Params", passingGrade +" " + numQuestions);
    }

    private void saveScore() {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("CID", courseCode);
        values.put("Score", (rightAnswers/numQuestions));
        values.put("Date", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));

        // Insert the new row, returning the primary key value of the new row
        long newRowId = dbWrite.insert("Quizzes", null, values);
    }
}
