package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
String nama, email, pass, kel, tgl, agama;
TextView Tnama, Tmail, Tpass, Tkel, Ttgl, Tagama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");
        Tnama = findViewById(R.id.textNama);
        Tmail = findViewById(R.id.textemail);
        Tpass = findViewById(R.id.textpassword);
        Tkel = findViewById(R.id.textkel);
        Ttgl = findViewById(R.id.texttgl);
        Tagama = findViewById(R.id.textagama);

        Bundle bun = getIntent().getExtras();
        if (bun != null){
            nama = bun.getString("nama");
            email = bun.getString("email");
            pass = bun.getString("pass");
            kel = bun.getString("kel");
            tgl = bun.getString("tgl");
            agama = bun.getString("agama");
            Tnama.setText(nama);
            Tmail.setText(email);
            Tpass.setText(pass);
            Tkel.setText(kel);
            Ttgl.setText(tgl);
            Tagama.setText(agama);
        }

    }
}
