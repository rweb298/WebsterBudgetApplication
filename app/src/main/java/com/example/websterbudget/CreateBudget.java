package com.example.websterbudget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateBudget extends AppCompatActivity {
    private static final String TAG = "CreateBudget";
    private static final int LENGTH_SHORT = 50;
    private static String msg = "Lets go through all of your finances";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createbudget_layout);
        Context context = getApplicationContext();
        CharSequence text = "Let's create a budget with your expected expenses";
        int duration= Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        //Store the budget numbers

        //Store the data and move it to next view
        Intent storeData = new Intent(CreateBudget.this, CreateAdditionalExpenses.class);
        ArrayList<String> storedData = new ArrayList<String>();
        storedData.add("Test Data 1");
        storedData.add("Test Data 2");
        storeData.putExtra("StoredData", storedData);
        startActivity(storeData);


    }

    }

