package com.example.gopillbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Models.UserMedicationView;

public class activity_alta_medicamento_pagina2 extends AppCompatActivity {
    EditText editTxtFrecuencia = findViewById(R.id.editTxtFrecuencia);
    EditText editTxtDuracion = findViewById(R.id.editTxtDuracion);
    EditText editTxtPrimeraToma = findViewById(R.id.editTxtPrimeraToma);
    Button btnAgregar = findViewById(R.id.btnAgregar);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_medicamento_pagina2);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String frecuencia = editTxtFrecuencia.getText().toString().trim();
                String duracion = editTxtDuracion.getText().toString().trim();
                String PrimeraToma = editTxtPrimeraToma.getText().toString().trim();

                Intent previousIntent = getIntent();
                if(previousIntent.hasExtra("newUserMedication")) {
                    // Retrieve data from Intent extras
                    UserMedicationView newUserMedication = (UserMedicationView) previousIntent.getSerializableExtra("newUserMedication");
                    newUserMedication.DosingFrequencyInHours = Float.parseFloat(frecuencia);
                    newUserMedication.TimeInTreatmentInDays = Integer.parseInt(duracion);
                    // Abrir la página 2 del formulario alta medicamento
                    Intent intent = new Intent(activity_alta_medicamento_pagina2.this, activity_menu.class);
                    intent.putExtra("newUserMedication", newUserMedication);
                    startActivity(intent);
                }
            }
        });
    }
}