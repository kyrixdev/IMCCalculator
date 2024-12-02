package com.example.imccalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvResultat = findViewById(R.id.tvResultat); // Texte pour afficher le résultat
        TextView tvInterprétation = findViewById(R.id.tvInterprétation); // Texte pour afficher l'interprétation
        Button btnRetour = findViewById(R.id.btnRetour); // Bouton pour revenir à l'activité principale

        // Récupérer les données transmises depuis la première activité
        Intent intent = getIntent();
        double poids = intent.getDoubleExtra("poids", 0); // Récupère le poids
        double taille = intent.getDoubleExtra("taille", 0); // Récupère la taille

        // Calculer l'IMC
        double imc = poids / (taille * taille);
        tvResultat.setText(String.format("Votre IMC est : %.2f", imc));

        // Déterminer l'interprétation de l'IMC
        String interprétation;
        if (imc < 18.5) {
            interprétation = "Insuffisance pondérale";
        } else if (imc >= 18.5 && imc < 24.9) {
            interprétation = "Poids normal";
        } else if (imc >= 25 && imc < 29.9) {
            interprétation = "Surpoids";
        } else {
            interprétation = "Obésité";
        }
        tvInterprétation.setText(interprétation);

        // Gérez le bouton de retour pour revenir à l'activité principale
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(retourIntent);
                finish(); // Ferme l'activité en cours pour empêcher la navigation vers cet écran
            }
        });
    }
}
