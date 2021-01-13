package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registrasi extends AppCompatActivity {

    MyDatabaseHelper db;
    Button registrasi;
    TextView login;
    EditText username, password, passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        db = new MyDatabaseHelper(this);

        username = (EditText)findViewById(R.id.regis_username);
        password = (EditText)findViewById(R.id.regis_password);
        passwordConfirm = (EditText)findViewById(R.id.regis_password_confirm);
        registrasi = (Button)findViewById(R.id.regis);
        login = (TextView)findViewById(R.id.link_login);

        //registrasi
        registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordConfirm = passwordConfirm.getText().toString();
                if(strPassword.equals(strPasswordConfirm)){
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if (daftar == true){
                        Toast.makeText(getApplicationContext(), "Anda Berhasil Mendaftar", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(registrasi.this, login.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Anda Gagal Mendaftar", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Confirmasi Password Gagal (Password Harus Sama)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}