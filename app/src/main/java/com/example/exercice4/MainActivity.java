package com.example.exercice4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

    private EditText editName, editEmail, editPhone, editAddress;
    private Spinner spinnerCity;
    private Button btnSend;
    private String selectedCity;  // Variable pour stocker la ville sélectionnée

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des composants
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        editAddress = findViewById(R.id.edit_address);
        spinnerCity = findViewById(R.id.spinner_city);
        btnSend = findViewById(R.id.btn_send);

        // Liste des villes
        String[] cities = {"Casablanca", "Rabat", "Marrakech", "Fès", "Tanger", "Agadir"};

        // Configuration du Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cities);
        spinnerCity.setAdapter(adapter);

        // Récupération de la ville sélectionnée
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = cities[position]; // Stocke la ville choisie
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCity = ""; // Si rien n'est sélectionné
            }
        });

        // Action sur le bouton Envoyer
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération des valeurs saisies
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();
                String address = editAddress.getText().toString();

                // Envoi des données à la deuxième activité
                Intent intent = new Intent(MainActivity.this, RecapActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                intent.putExtra("address", address);
                intent.putExtra("city", selectedCity);
                startActivity(intent);
            }
        });
    }
}
