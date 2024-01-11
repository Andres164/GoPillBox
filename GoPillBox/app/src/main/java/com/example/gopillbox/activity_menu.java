package com.example.gopillbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Models.UserMedicationView;

public class activity_menu extends AppCompatActivity {

    private TableLayout tableLayout;
    private List<UserMedicationView> userMedicationList = new ArrayList<UserMedicationView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FloatingActionButton btnAddMedicamento = findViewById(R.id.Button_add);

        tableLayout = findViewById(R.id.TableMedicamentos);


        Intent intent = getIntent();
        if(intent.hasExtra("newUserMedication0")) {

            int numMedicaciones = intent.getIntExtra("numMedications", 0);
            for (int i = 0; i < numMedicaciones; i++) {
                UserMedicationView medication = (UserMedicationView) intent.getSerializableExtra(("newUserMedication"+i));
                userMedicationList.add(medication);
            }

            // Add rows to the TableLayout dynamically
            for (UserMedicationView userMedication : userMedicationList) {
                TableRow row = new TableRow(this);

                // Add TextViews for each column
                TextView medicationNameTextView = createTextView(userMedication.MedicationName);
                TextView doseTextView = createTextView(String.valueOf(userMedication.Dose));

                // Add more TextViews for additional columns as needed

                // Add TextViews to the TableRow
                row.addView(medicationNameTextView);
                row.addView(doseTextView);

                // Add the TableRow to the TableLayout
                tableLayout.addView(row);
            }
        }
        btnAddMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //abre la pagina 1 del formulario alta medicamento
                Intent intent = new Intent(activity_menu.this, activity_alta_medicamento_pagina1.class);
                int i = 0;
                for(UserMedicationView medication :userMedicationList) {
                    intent.putExtra(("newUserMedication"+i), medication);
                    i++;
                }
                intent.putExtra("numMedications", i);
                startActivity(intent);
            }

        });
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }
}