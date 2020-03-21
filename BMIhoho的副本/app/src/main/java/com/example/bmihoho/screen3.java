package com.example.bmihoho;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.os.Bundle;

public class screen3 extends AppCompatActivity {
    TextView result,shows;
    float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        result = (TextView) findViewById(R.id.result);
        shows = (TextView) findViewById(R.id.shows);
        Intent intent = getIntent();
        String str = intent.getStringExtra("result");
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, Float.parseFloat(str));
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float r = (float) animation.getAnimatedValue();
                float roundedResult = (float) (Math.round(r * 100.0) / 100.0);
                result.setText(String.valueOf(roundedResult));
            }
        });
        animator.start();
        Handler handler=new Handler();
        setBmi(Float.parseFloat(str));
        handler.postDelayed(new Runnable() {
            @Override

            public void run() {

                if (getBmi()<18.5){
                    shows.setText("Enjoy KFC ><");
                    shows.setTextColor(Color.parseColor("#084177"));
                }
                if (getBmi()<=24&&getBmi()>=18.5){
                    shows.setText("Nice body !!");
                    shows.setTextColor(Color.parseColor("#596157"));
                }
                if (getBmi()>24){
                    shows.setText("Go to gym - -");
                    shows.setTextColor(Color.parseColor("#A37272"));
                }
            }
        },3000);

    }
    public void setBmi(float bmi)
    {
        this.bmi=bmi;
    }

    public float getBmi() {
        return bmi;
    }
}



