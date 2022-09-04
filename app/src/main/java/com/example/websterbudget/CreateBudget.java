package com.example.websterbudget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
    private double primaryIncomeNum;
    private double otherIncomeNum;
    private double mortgageNum;
    private double electricNum;
    private double cableNum;
    private double waterNum;
    private double homeInsuranceNum;
    private TextView primaryIncome;
    private TextView otherIncome;
    private TextView mortgage;
    private TextView electric;
    private TextView cable;
    private TextView water;
    private TextView homeInsurance;
    private Button btnBack;
    private Button btnNext;
    private ArrayList<Double> incomeHouseExpenses;


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
        primaryIncome = findViewById(R.id.primaryIncomeNumber);
        primaryIncomeNum = Double. parseDouble(primaryIncome.getText().toString());
        otherIncome = findViewById(R.id.otherIncomeNumber);
        otherIncomeNum = Double.parseDouble(otherIncome.getText().toString());
        mortgage = findViewById(R.id.mortgageRentNumber);
        mortgageNum = Double.parseDouble(mortgage.getText().toString());
        electric = findViewById(R.id.electricGasNumber);
        electricNum = Double.parseDouble(electric.getText().toString());
        cable = findViewById(R.id.cableInternetNumber);
        cableNum = Double.parseDouble(cable.getText().toString());
        water = findViewById(R.id.waterTrashNumber);
        waterNum = Double.parseDouble(water.getText().toString());
        homeInsurance = findViewById(R.id.homeInsuranceNumber);
        homeInsuranceNum = Double.parseDouble(homeInsurance.getText().toString());
        //adding the expense numbers to an array list to pass into next screen
        incomeHouseExpenses = new ArrayList<Double>();
        incomeHouseExpenses.add(primaryIncomeNum);
        incomeHouseExpenses.add(otherIncomeNum);
        incomeHouseExpenses.add(mortgageNum);
        incomeHouseExpenses.add(electricNum);
        incomeHouseExpenses.add(cableNum);
        incomeHouseExpenses.add(waterNum);
        incomeHouseExpenses.add(homeInsuranceNum);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        //setting a listener for the textViews and Buttons
        primaryIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDefaultValue(primaryIncome);
            }
        });
        otherIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDefaultValue(otherIncome);
            }
        });
        mortgage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDefaultValue(mortgage);
            }
        });
        electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDefaultValue(electric);
            }
        });
        cable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDefaultValue(cable);
            }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDefaultValue(water);
            }
        });
        homeInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDefaultValue(homeInsurance);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Inside back button");
                backButton();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Inside next button");
                Intent goToNext = new Intent(CreateBudget.this, CreateAdditionalExpenses.class);
                //putting data for next page
                goToNext.putExtra("StoredData", incomeHouseExpenses);
                startActivity(goToNext);
            }
        });



    }
    public void backButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateBudget.this);
        builder.setMessage("Do you want to exit without saving?");
        builder.setTitle("Alert!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            finish();
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    //Clearing the default 0 when the user clicks on the textview
    public void clearDefaultValue(TextView txtView) {
        txtView.setText("");
    }
    }

