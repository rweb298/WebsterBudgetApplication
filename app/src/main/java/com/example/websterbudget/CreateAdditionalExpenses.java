package com.example.websterbudget;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CreateAdditionalExpenses extends AppCompatActivity {
    private final String TAG = "CreateAdditional";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createadditionalexpenses_layout);
        ArrayList<Double> previousData = new ArrayList<Double>();
        Intent createBudgetIntent = getIntent();
        Bundle args = createBudgetIntent.getBundleExtra("BUNDLE");
        ArrayList<Double> data = (ArrayList<Double>) args.getSerializable("ARRAYLIST");
        Log.d(TAG, "Array List from previous = " + data.toString());

    }

}
