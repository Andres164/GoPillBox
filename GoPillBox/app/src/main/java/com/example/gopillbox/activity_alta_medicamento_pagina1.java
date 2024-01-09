package com.example.gopillbox;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_alta_medicamento_pagina1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_medicamento_pagina1);

        Button btnSiguiente = findViewById(R.id.btn_siguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la página 2 del formulario alta medicamento
                Intent intent = new Intent(activity_alta_medicamento_pagina1.this, activity_alta_medicamento_pagina2.class);
                startActivity(intent);
            }
        });
    }
}
