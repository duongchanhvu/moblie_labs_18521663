package com.example.test;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DatabaseHelper;
import objects.Person;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference usersRef = db.collection("users");
    Button addDataBtn, addDataLocalBtn;

    Button queryDataBtn, queryDataLocalBtn;

    EditText inputName;
    EditText inputPhoneNumber;

    DatabaseHelper databaseHelper;

    TextView dataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.fullName);
        inputPhoneNumber = findViewById(R.id.phoneNumber);

        addDataBtn = findViewById(R.id.addDataBtn);
        queryDataBtn = findViewById(R.id.queryDataRemoteBtn);

        addDataLocalBtn = findViewById(R.id.addDataLocal);
        queryDataLocalBtn = findViewById(R.id.queryAllDataLocalBtn);

//        dataTextView = findViewById(R.id.dataTextView);

        databaseHelper = new DatabaseHelper(this);



        addDataLocalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String phone = inputPhoneNumber.getText().toString();
                Person a = new Person(name, phone);
                databaseHelper.insertContact(a);
                Toast.makeText(MainActivity.this, "Contact saved to database", Toast.LENGTH_SHORT).show();
            }
        });

        queryDataLocalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                List<String> dataList = databaseHelper.getAllData();
//                StringBuilder sb = new StringBuilder();
//                for (String data : dataList){
//                    sb.append(data).append("\n");
//                }
//                dataTextView.setText(sb.toString());

                Intent intent;
                intent = new Intent(MainActivity.this, ShowAllLocalData.class);
                startActivity(intent);
                finish();

            }
        });

        addDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = inputName.getText().toString();
                String phone = inputPhoneNumber.getText().toString();

                Map<String, Object> data = new HashMap<>();
                data.put("Name", name);
                data.put("PhoneNumber", phone);
                usersRef.add(data)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            }
        });


    }
}