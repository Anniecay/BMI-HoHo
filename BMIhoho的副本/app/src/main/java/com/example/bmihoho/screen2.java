package com.example.bmihoho;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class screen2 extends AppCompatActivity {
    public EditText height,weight;
    public TextView errorshow,designer;
    public EditText heightField;
    public EditText weightField;

    float bmi;
    private Switch mSwitch;
    private TextView mText;
    boolean isMetric = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        errorshow=(TextView)
                findViewById(R.id.errorshow);
        heightField=(EditText)
                findViewById(R.id.heightin);
        weightField=(EditText)
                findViewById(R.id.weightin);
        mSwitch = (Switch) findViewById(R.id.switch1);
        designer = findViewById(R.id.designer);

        mSwitch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mSwitch.isChecked()){
                    mSwitch.setText("Imperial");
                    isMetric = false;

                }else{
                    isMetric = true;
                    mSwitch.setText("metric");
                }
            }
        });

        designer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screen2.this, myselfActivity.class);
                startActivity(intent);
            }
        });

        errorshow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(screen2.this,screen3.class);
                intent.putExtra("result",Float.toString(getBmi()));
                startActivity(intent);
            }
        });
    }
    public static boolean checkForEmptyField(EditText textField) {
        return textField.getText().toString().trim().length() <= 0;
    }
    public void catchNumber(View v){

        weight=(EditText)findViewById(R.id.weightin);
        height=(EditText)findViewById(R.id.heightin);
        try{
            float w,h;
            w=Float.parseFloat(weight.getText().toString());
            h=Float.parseFloat(height.getText().toString());

            if(isMetric){
                bmi= (float) (w/Math.pow(h/100,2));

            }else {
                bmi = (float) ((w*703)/Math.pow(h,2));
            }
            setBmi(bmi);
            errorshow.setText(Float.toString(bmi));

        }catch(Exception e){
            errorshow.setTextColor(getResources().getColor(R.color.white));
            errorshow.setTextSize(22);
            if(checkForEmptyField(heightField)){
                errorshow.setText("enter height");
            }
            if(checkForEmptyField(weightField)){
                errorshow.setText("enter weight");
            }
        }

    }


    public void setBmi(float bmi) {
        this.bmi=bmi;
    }
    public float getBmi(){
        return bmi;
    }
}
