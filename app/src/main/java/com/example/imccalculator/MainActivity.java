package com.example.imccalculator; // Définit le package de l'application

import android.content.Intent; // Importation pour gérer les intentions (passage entre activités)
import android.os.Bundle; // Importation pour gérer l'état des activités
import android.view.View; // Importation pour manipuler les vues
import android.widget.Button; // Importation pour manipuler les boutons
import android.widget.EditText; // Importation pour manipuler les champs de texte
import android.widget.Toast; // Importation pour afficher des messages Toast

import androidx.appcompat.app.AppCompatActivity; // Classe de base pour une activité utilisant AppCompat

// Classe principale de l'activité d'accueil
public class MainActivity extends AppCompatActivity {

    // Méthode appelée lorsque l'activité est créée
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Appelle la méthode de création de la superclasse
        setContentView(R.layout.activity_main); // Définit la mise en page associée à cette activité

        // Liaison des composants de la mise en page aux variables Java
        EditText etPoids = findViewById(R.id.etPoids); // Champ pour entrer le poids
        EditText etTaille = findViewById(R.id.etTaille); // Champ pour entrer la taille
        Button btnCalculer = findViewById(R.id.btnCalculer); // Bouton pour calculer l'IMC

        // Définition du comportement du bouton lorsqu'il est cliqué
        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération des valeurs entrées dans les champs de texte
                String poidsStr = etPoids.getText().toString(); // Poids sous forme de chaîne
                String tailleStr = etTaille.getText().toString(); // Taille sous forme de chaîne

                // Vérification que les champs ne sont pas vides
                if (poidsStr.isEmpty() || tailleStr.isEmpty()) {
                    // Affiche un message Toast pour alerter l'utilisateur
                    Toast.makeText(MainActivity.this, "Veuillez entrer votre poids et votre taille.", Toast.LENGTH_SHORT).show();
                    return; // Interrompt l'exécution si les champs sont vides
                }

                // Conversion des chaînes en valeurs numériques
                double poids = Double.parseDouble(poidsStr); // Conversion du poids
                double taille = Double.parseDouble(tailleStr); // Conversion de la taille

                // Création d'une intention pour passer à l'activité suivante
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                // Ajout des données (poids et taille) à l'intention
                intent.putExtra("poids", poids); // Ajoute du poids
                intent.putExtra("taille", taille); // Ajoute du taille

                // Démarre l'activité suivante en passant l'intention
                startActivity(intent);
            }
        });
    }
}
