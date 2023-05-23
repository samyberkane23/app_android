package com.example.monprojetfinale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bouton1 = findViewById(R.id.bouton1_act0);
        bouton2 = findViewById(R.id.bouton2_act0);
        bouton3 = findViewById(R.id.bouton3_act0);
        textView = findViewById(R.id.textView_act0);

        bouton1.setOnClickListener(this::onClick);
        bouton2.setOnClickListener(this::onClick);
        bouton3.setOnClickListener(this::onClick);
        bouton1.setBackgroundColor(Color.BLACK);
        bouton1.setTextColor(Color.WHITE);
        bouton2.setBackgroundColor(Color.BLACK);
        bouton2.setTextColor(Color.WHITE);
        bouton3.setBackgroundColor(Color.BLACK);
        bouton3.setTextColor(Color.WHITE);


    }


    void onClick(View view){

        if(view == this.bouton1){
            Intent MainActivity2 = new Intent(MainActivity.this, com.example.monprojetfinale.MainActivity2.class);
            startActivity(MainActivity2);

        }
        if(view == this.bouton2){
            Intent MainActivity3 = new Intent(MainActivity.this, com.example.monprojetfinale.MainActivity3.class);
            startActivity(MainActivity3);

        }
        if(view == this.bouton3){
            Intent MainActivity4 = new Intent(MainActivity.this, com.example.monprojetfinale.MainActivity4.class);
            startActivity(MainActivity4);

        }


    }

}