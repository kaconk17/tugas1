package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class Form extends AppCompatActivity {

    EditText tgl_lahir;
    DatePickerDialog picker;
    Spinner spinnerDropView;
    String[] spinnerValue = {"Islam", "Kristen", "Hindu", "Budha", "Katholik"};
    String agama, nama, email, password, kel, tgl;

    FloatingActionButton send_btn;
    EditText Tnama, Tmail, Tpass;
RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        setTitle("Formulir");
        send_btn = findViewById(R.id.btn_send);
        tgl_lahir = findViewById(R.id.textTgl);
        Tnama = findViewById(R.id.textNama);
        Tmail = findViewById(R.id.textEmail);
        Tpass = findViewById(R.id.textPassword);
        radio = findViewById(R.id.radioGroup);
        radio.check(R.id.radioLaki);
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
                //String text = parent.getItemAtPosition(position).toString();
                agama = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        send_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               nama = Tnama.getText().toString();
               email = Tmail.getText().toString();
               password = Tpass.getText().toString();
               tgl = tgl_lahir.getText().toString();

              int pilih = radio.getCheckedRadioButtonId();

                  RadioButton radioBut = findViewById(pilih);
                  kel = radioBut.getText().toString();
                  Intent intent = new Intent(Form.this, ResultActivity.class);
                  Bundle bun = new Bundle();
                  bun.putString("nama", nama);
                  bun.putString("email", email);
                  bun.putString("pass", password);
                  bun.putString("kel", kel);
                  bun.putString("tgl", tgl);
                  bun.putString("agama", agama);
                  intent.putExtras(bun);
                  startActivity(intent);

            }
        });

    }
}
