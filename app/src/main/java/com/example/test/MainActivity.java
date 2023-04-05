package com.example.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText grossSalary, fullName;
    protected Button myBtn;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName = findViewById(R.id.fullName);
        grossSalary = findViewById(R.id.grossSalary);
        myBtn = findViewById(R.id.calcBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = fullName.getText().toString();
                double number = Double.parseDouble(grossSalary.getText().toString());
                PersonalSalary netSalary = new PersonalSalary(text, number);
                netSalary.calculationNetSalary();
            }
        });
    }
}