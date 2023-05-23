package com.example.monprojetfinale;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    private TextView textView1;
    private Button boutona ;
    private Button boutonb;
    private Button boutonc;
    private Button boutond;
    private Button boutone;
    public String[] tableauChaine = {"Rouge","Rose", "Blanc","Vert"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView1 = findViewById(R.id.textView_act2);
        boutona = findViewById(R.id.bouton1_act2);
        boutonb = findViewById(R.id.bouton2_act2);
        boutonc = findViewById(R.id.bouton3_act2);
        boutond = findViewById(R.id.bouton4_act2);
        boutone = findViewById(R.id.bouton5_act2);

        boutona.setOnClickListener(this::onClick);
        boutonb.setOnClickListener(this::onClick);
        boutonc.setOnClickListener(this::onClick);
        boutond.setOnClickListener(this::onClick);
        boutone.setOnClickListener(this::onClick);

        boutone.setBackgroundColor(Color.BLACK);
        boutone.setTextColor(Color.WHITE);




        random_text();
    }
        public void onClick(View view) {
            if (view == this.boutond  && textView1.getText() == tableauChaine[0] ) {
                Toast.makeText(MainActivity3.this, "Bravo vous l'avez trouver !" +
                        " Passez à l'activité suivante ", Toast.LENGTH_SHORT).show();
                textView1.setTextColor(Color.RED);
                afficherBoiteDeDialogue();
            }

            else if (view == this.boutona  && textView1.getText() == tableauChaine[3] ) {
                Toast.makeText(MainActivity3.this, "Bravo vous l'avez trouver !" +
                        " Passez à l'activité suivante ", Toast.LENGTH_SHORT).show();
                textView1.setTextColor(Color.GREEN);
                afficherBoiteDeDialogue();
            }

            else if (view == this.boutonb  && textView1.getText() == tableauChaine[1] ) {
                Toast.makeText(MainActivity3.this, "Bravo vous l'avez trouver !" +
                        " Passez à l'activité suivante ", Toast.LENGTH_SHORT).show();
                textView1.setTextColor(Color.MAGENTA);
                afficherBoiteDeDialogue();
            }

            else if (view == this.boutonc  && textView1.getText() == tableauChaine[2] ) {
                Toast.makeText(MainActivity3.this, "Bravo vous l'avez trouver !" +
                        " Passez à l'activité suivante ", Toast.LENGTH_SHORT).show();
                textView1.setTextColor(Color.GRAY);
                afficherBoiteDeDialogue();
            }else if (view == this.boutone  ){
                Intent MainActivity4 = new Intent(MainActivity3.this, com.example.monprojetfinale.MainActivity4.class);
                startActivity(MainActivity4);
            }
            else{
                Toast.makeText(MainActivity3.this, "Ce n'est pas la bonne couleur " , Toast.LENGTH_SHORT).show();
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
                    .setMessage("Cliquez sur Oui ")
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


        public void random_text(){

            int rnd = new Random().nextInt(tableauChaine.length);
            textView1.setText(tableauChaine[rnd]);

        }


}