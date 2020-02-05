package com.example.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ListView;
import java.util.ArrayList;
public class ExamResultsActivity extends AppCompatActivity {

    ArrayList<Score> pastResults = new ArrayList<Score>();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_results_screen);
        final Toolbar toolbar = findViewById(R.id.toolbarExamResults);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, ResultsActivity.class);

        lv = findViewById(R.id.listViewResults);
        ArrayList<String> courseHistory = new ArrayList<String>();
        courseHistory.add("Classics\n2020-02-02\n10/20");
        courseHistory.add("Geography\n2020-02-02\n20/20");
        courseHistory.add("Classics\n2020-01-02\n20/20");
        courseHistory.add("Classics\n2020-31-01\n18/20");
        courseHistory.add("Geography\n2020-20-01\n11/20");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courseHistory);
        lv.setAdapter(listAdapter);

        Bundle args =  intent.getBundleExtra("history");
        if (args != null) {
            pastResults = (ArrayList<Score>) args.getSerializable("ARRAYLIST");
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = toolbar.getChildAt(0);
                startActivity(new Intent(ExamResultsActivity.this, MainActivity.class));
            }
        });
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