package com.jovanovic.stefan.sqlitetutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddActivity extends AppCompatActivity {

   // final int REQUEST_CODE_GALERY = 999;
    EditText title_input, author_input, pages_input;
    Button add_button, add_image;
//    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

//        add_image = findViewById(R.id.add_image);
//        image = findViewById(R.id.image);
        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);

//        add_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ActivityCompat.requestPermissions(AddActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_GALERY);
//            }
//        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                //byte[] NewEntryImg = imageViewToByte(image);
                myDB.addBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()));
            }
//
//
//            public void onRequestPermissionsResults(int requestCode, @NonNull String[] permissions, @NonNull int[]grantResults){
//                if (requestCode == REQUEST_CODE_GALERY){
//                    if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                        Intent intent = new Intent(Intent.ACTION_PICK);
//                        intent.setType("image/*");
//                        startActivityForResult(intent,REQUEST_CODE_GALERY);
//                    }
//                    else{
//                        Toast.makeText(getApplicationContext(), "Anda Tidak Memiliki file", Toast.LENGTH_SHORT).show();
//                    }
//                    return;
//                }
//                AddActivity.super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            }
//
//
//            protected void onActivityResult(int requestCode, int resultCode, Intent data){
//                Uri uri = data.getData();
//                try {
//                    InputStream inputStream = getContentResolver().openInputStream(uri);
//                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                    image.setImageBitmap(bitmap);
//                }
//                catch (FileNotFoundException e){
//                    e.printStackTrace();
//                }
//                AddActivity.super.onActivityResult(requestCode, resultCode, data);
//            }
//
//            private byte[] imageViewToByte(ImageView image) {
//                Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
//                byte[] byteArray = stream.toByteArray();
//                return byteArray;
//            }
        });
    }
}
