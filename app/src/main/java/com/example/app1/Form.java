package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Calendar;

public class Form extends AppCompatActivity {

    EditText tgl_lahir;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        setTitle("Formulir");

        tgl_lahir = (EditText) findViewById(R.id.textTgl);
        tgl_lahir.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                final Calendar cldr = Calendar.getInstance();
                final int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(Form.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                        tgl_lahir.setText(year+"-"+monthOfyear+"-"+dayOfMonth);
                    }
                }, year, month,day);
                picker.show();
            }

        });

    }
}
