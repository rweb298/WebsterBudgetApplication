package com.example.websterbudget;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String DIRECTORY = "/WebsterBudget";
    private static String absolutePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestWritePermissions();
        //requestReadPermissions();
       // createDirectory();
        Button btnCreateBudget = (Button) findViewById(R.id.btnStartNewBudget);
        Button btnEditBudget = (Button) findViewById(R.id.btnEditBudget);

        //Set listener for btnCreateBudget
        btnCreateBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create intent so it switches from MainActivity to createbudget_layout
                Intent createBudgetIntent = new Intent(MainActivity.this, CreateBudget.class);
                startActivity(createBudgetIntent);
            }
        });

        //Set Listener for EditBudget


    }
        public void requestWritePermissions() {
            //if write permission is not granted then ask for write permissions
            if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

            }
        }
        public void requestReadPermissions() {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);

            }
        }
        public void createDirectory() {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Permission was granted");
                    File directory = new File(Environment.getExternalStorageDirectory(),DIRECTORY);
                    Log.d(TAG, "Directory exists " +directory.exists());
                    absolutePath = directory.getAbsolutePath();
                    Log.d(TAG, "Path = " + absolutePath);
                    Log.d(TAG, "Is Directory? " + directory.isDirectory());
                    if (!directory.exists()) {
                        directory.mkdirs();
                        Log.d(TAG, "Directory exists " +directory.exists());

                        Log.d(TAG, "Current Directory " + System.getProperty("user.dir"));
                    } else {
                        Log.d(TAG, "Not making directory, one already exists");
                    }
                } else {
                    Log.d(TAG, "Permission not granted");
                }
            }
        }
