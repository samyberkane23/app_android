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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    private Button boutona;
    private Button boutonb;
    private TextView textViewa;

    private EditText editexta;


    public int nb,nb2,nb3,nb4,nb5,nb6;
    public int rnd,rnd2,rnd3;
    public String[] tableauChaine = {"+","*", "-"};
    public  String phrase;
    public  String phrase1;
    public  String phrase2;

    public int totale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        editexta = findViewById(R.id.editext1_act3);

        textViewa = findViewById(R.id.textView1_act3);


        boutona = findViewById(R.id.bouton1_act3);
        boutonb = findViewById(R.id.bouton2_act3);
        random_text();
        boutona.setBackgroundColor(Color.BLACK);
        boutona.setTextColor(Color.WHITE);
        boutonb.setBackgroundColor(Color.BLACK);
        boutonb.setTextColor(Color.WHITE);

        boutona.setOnClickListener(this::onClick);
        boutonb.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {


        if (view == this.boutona) {

            if(tableauChaine[rnd] == tableauChaine[0] ){
                totale = nb + nb2;

            }else if(tableauChaine[rnd] == tableauChaine[1] ){
                totale = nb * nb2;

            }else{
                totale = nb - nb2;

            }
            String mot = editexta.getText().toString();

            int entier = Integer.parseInt(mot);

            if(entier == totale  ){
                afficherBoiteDeDialogue();
                Toast.makeText(MainActivity4.this, "vous l'avez trouver  " , Toast.LENGTH_SHORT).show();
            }

        }
        if (view == boutonb){
            Intent MainActivity = new Intent(MainActivity4.this, com.example.monprojetfinale.MainActivity.class);
            startActivity(MainActivity);

        }



    }
    public void random_text(){
        Random random = new Random();
        rnd = new Random().nextInt(tableauChaine.length);
        rnd2 = new Random().nextInt(tableauChaine.length);
        rnd3 = new Random().nextInt(tableauChaine.length);

        textViewa.setText(tableauChaine[rnd]);

        nb = random.nextInt(5);
        Random random2 = new Random();
        nb2 = random2.nextInt(5);
        Random random3 = new Random();
        nb3 = random3.nextInt(5);
        Random random4 = new Random();
        nb4 = random4.nextInt(5);
        Random random5 = new Random();
        nb5 = random5.nextInt(5);
        Random random6 = new Random();
        nb6 = random6.nextInt(5);

        String phrase = nb +"   "+ tableauChaine[rnd] +"   "+ nb2+" =";

        textViewa.setText(phrase);
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
                .setMessage("Revenir au  Menu ")
                .setPositiveButton("Oui", dialogListener)
                .show();
    }

    private void onClickBoiteDeDialogue(DialogInterface dialog, int which) {
        switch (which) {
            case AlertDialog.BUTTON_POSITIVE:
                new AlertDialog.Builder(this).setMessage("Cliquez Sur Revenir Au menu !").show();
                break;
        }
    }


}