package com.example.gopillbox;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import Models.UserMedicationView;

public class activity_alta_medicamento_pagina1 extends AppCompatActivity {

    private EditText editText_NombreMedicamento, editText_dosis, editTextCantidad;
    List<UserMedicationView> medications = new ArrayList<UserMedicationView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_medicamento_pagina1);
        EditText editText_NombreMedicamento = findViewById(R.id.editText_NombreMedicamento);
        EditText editText_dosis = findViewById(R.id.editText_dosis);
        EditText editTextCantidad = findViewById(R.id.editTextCantidad);
        Button btnSiguiente = findViewById(R.id.btn_siguiente);

        Intent prevIntent = getIntent();
        int numMedications = prevIntent.getIntExtra("numMedications", 0);
        if(prevIntent.hasExtra("newUserMedication0")) {
            for(int j = 0; j < numMedications; j++) {
                UserMedicationView medication = (UserMedicationView) prevIntent.getSerializableExtra(("newUserMedication"+j));
                medications.add(medication);
            }
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreMedicamento = editText_NombreMedicamento.getText().toString().trim();
                String dosis = editText_dosis.getText().toString().trim();
                String cantidad = editTextCantidad.getText().toString().trim();

                // Abrir la página 2 del formulario alta medicamento
                Intent intent = new Intent(activity_alta_medicamento_pagina1.this, activity_menu.class);

                UserMedicationView newUserMedication = new UserMedicationView();
                // Pass data to the next activity using Intent extras
                newUserMedication.UserId = 0;
                newUserMedication.MedicationName  = nombreMedicamento + " " + dosis;
                newUserMedication.Dose = Float.parseFloat(cantidad);
                medications.add(newUserMedication);

                int i = 0;
                for(UserMedicationView medication :medications) {
                    intent.putExtra(("newUserMedication"+i), medication);
                    i++;
                }
                intent.putExtra("numMedications", i);
                startActivity(intent);
            }
        });
    }
}
