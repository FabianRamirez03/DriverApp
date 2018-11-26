package com.example.ramir.driverapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button continueBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continueBtn = findViewById(R.id.continueBtn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(ScannerActivity.scanResult != null){
            continueButton();
        }
    }

    public void continueButton(){
        continueBtn.setVisibility(View.VISIBLE);
    }


    public void openMapActivity(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
    public void openScannerActivity(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
