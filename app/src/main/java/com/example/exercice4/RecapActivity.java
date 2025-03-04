package com.example.exercice4;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RecapActivity extends Activity {

    private TextView txtRecap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        txtRecap = findViewById(R.id.txt_recap);

        // Récupération des données envoyées depuis MainActivity
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("address");
        String city = getIntent().getStringExtra("city");

        // Affichage des données
        String recapText = "Nom : " + name + "\n" +
                "Email : " + email + "\n" +
                "Téléphone : " + phone + "\n" +
                "Adresse : " + address + "\n" +
                "Ville : " + city;

        txtRecap.setText(recapText);
    }
}
