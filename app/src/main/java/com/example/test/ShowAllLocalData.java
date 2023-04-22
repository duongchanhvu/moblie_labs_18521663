package com.example.test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

import database.DatabaseHelper;

public class ShowAllLocalData extends AppCompatActivity {

    TextView dataTextView;
    DatabaseHelper databaseHelper;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_local_data);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        dataTextView = findViewById(R.id.dataTextView);
        databaseHelper = new DatabaseHelper(this);

        List<String> dataList = databaseHelper.getAllData();
        StringBuilder sb = new StringBuilder();
        for (String data : dataList){
            sb.append(data).append("\n");
        }
        dataTextView.setText(sb.toString());

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}