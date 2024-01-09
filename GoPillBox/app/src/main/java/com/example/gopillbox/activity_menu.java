package com.example.gopillbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FloatingActionButton btnAddMedicamento = findViewById(R.id.Button_add);

        btnAddMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //abre la pagina 1 del formulario alta medicamento
                Intent intent = new Intent(activity_menu.this, activity_alta_medicamento_pagina1.class);
                startActivity(intent);
            }

        });
    }
}