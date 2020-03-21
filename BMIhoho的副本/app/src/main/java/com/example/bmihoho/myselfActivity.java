package com.example.bmihoho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class myselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myself);
    }

    public void goBack(View v){

        Intent intent = new Intent(myselfActivity.this, screen2.class);
        startActivity(intent);
    }
}
