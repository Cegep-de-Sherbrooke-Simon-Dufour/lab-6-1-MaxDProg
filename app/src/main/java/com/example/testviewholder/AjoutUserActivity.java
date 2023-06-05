package com.example.testviewholder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutUserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_user);

        Button btnAjouter = findViewById(R.id.button_ajouter);
        btnAjouter.setOnClickListener(ajouter);
        Button btnAnnuler = findViewById(R.id.button_annuler);
        btnAnnuler.setOnClickListener(annuler);

    }

    View.OnClickListener annuler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setResult(RESULT_CANCELED);
            finish();
        }

    };

    View.OnClickListener ajouter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            EditText nom = findViewById(R.id.editTextText_name);
            String Nom = nom.getText().toString();
            EditText email = findViewById(R.id.editTextText_email);
            String Email = email.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("nom", Nom);
            resultIntent.putExtra("email", Email);
            setResult(RESULT_OK, resultIntent);

            finish();
        }

    };
}
