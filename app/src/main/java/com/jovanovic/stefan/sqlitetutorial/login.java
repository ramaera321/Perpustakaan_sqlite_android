package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    MyDatabaseHelper db;
    Button login;
    TextView registrasi;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new MyDatabaseHelper(this);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login    = (Button)findViewById(R.id.login);
        registrasi = (TextView)findViewById(R.id.link_regis);


        //registrasi
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registIntent = new Intent(login.this, registrasi.class);
                startActivity(registIntent);
                finish();
            }
        });

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                Boolean masuk = db.loginUser(strUsername, strPassword);
                if (masuk == true){
                    Boolean updtSession = db.upgradeSession("ada", 1);
                    if (updtSession == true){
                        Toast.makeText(getApplicationContext(), "Anda Berhasil Masuk", Toast.LENGTH_SHORT).show();
                        Intent logIntent = new Intent(login.this, MainActivity.class);
                        startActivity(logIntent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Anda Tidak Masuk", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}