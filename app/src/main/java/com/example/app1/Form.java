package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.Calendar;

public class Form extends AppCompatActivity {

    EditText tgl_lahir;
    DatePickerDialog picker;
    Spinner spinnerDropView;
    String[] spinnerValue = {"Islam", "Kristen", "Hindu", "Budha", "Katholik"};
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

        spinnerDropView = (Spinner) findViewById(R.id.spinagama);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Form.this, android.R.layout.simple_list_item_1, spinnerValue);
        spinnerDropView.setAdapter(adapter);
        spinnerDropView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
