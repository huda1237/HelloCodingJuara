package com.juaracoding.huda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    String username, password;
    TextView txtUsername;
    ImageView btnTambahData,btnexit,btnlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        txtUsername = findViewById(R.id.txtUsername);
        btnTambahData = findViewById(R.id.btnTambahData);
        btnlist = findViewById(R.id.btnlist);
        btnexit = findViewById(R.id.btnexit);
        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");



        txtUsername.setText(username);

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,TambahData.class);
                startActivity(intent);
            }
        });

        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,ListBiodata.class);
                startActivity(intent);
            }
        });
    }


}