package com.example.monprojetfinale;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button bouton5;
    private Button bouton6;

    private EditText editText1;
    private EditText editText2;


    public String[] tabMot={"rage","gare"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText1 = findViewById(R.id.editText_act1);
        editText2 = findViewById(R.id.editText2_act1);

        bouton5 = findViewById(R.id.bouton1_act1);
        bouton6 = findViewById(R.id.bouton2_act1);

        bouton5.setOnClickListener(this::onClick);
        bouton6.setOnClickListener(this::onClick);
        bouton5.setBackgroundColor(Color.BLACK);
        bouton5.setTextColor(Color.WHITE);
        bouton6.setBackgroundColor(Color.BLACK);
        bouton6.setTextColor(Color.WHITE);


    }

    public void onClick(View view) {



        if (view == this.bouton6) {
            Intent MainActivity3 = new Intent(MainActivity2.this, com.example.monprojetfinale.MainActivity3.class);
            startActivity(MainActivity3);
        }

        if (view == this.bouton5) {

            String mot = editText1.getText().toString().trim();
            String mot2 = editText2.getText().toString().trim();
            if ((mot.equals(tabMot[0]) || mot.equals(tabMot[1]) ) && (mot2.equals(tabMot[0]) || mot2.equals(tabMot[1]))) {
                Toast.makeText(MainActivity2.this, "Bravo Vous les avez trouver !", Toast.LENGTH_LONG).show();
                afficherBoiteDeDialogue();
            }else if (mot.length() == 0 || mot2.length() == 0) {
                Toast.makeText(MainActivity2.this, "Vous n'avez pas saisie de mot !", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(MainActivity2.this, "Les mots que vous avez trouvez sont faux !", Toast.LENGTH_LONG).show();

            }
        }
    }

    public void afficherBoiteDeDialogue() {
        DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickBoiteDeDialogue(dialog, which);
            }
        };

        new AlertDialog.Builder(this)
                .setTitle("Bravo !!")
                .setMessage("Cliquez sur Oui")
                .setPositiveButton("Oui", dialogListener)
                .show();
    }

    private void onClickBoiteDeDialogue(DialogInterface dialog, int which) {
        switch (which) {
            case AlertDialog.BUTTON_POSITIVE:
                new AlertDialog.Builder(this).setMessage("Cliquez sur suivant !").show();
                break;
        }
    }


}