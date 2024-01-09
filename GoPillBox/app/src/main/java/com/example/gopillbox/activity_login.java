package com.example.gopillbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnRegistrarse = findViewById(R.id.Btn_registrarse);
        Button btnIniciar =findViewById(R.id.btn_iniciar);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de registro
                Intent intent = new Intent(activity_login.this, activity_registro.class);
                startActivity(intent);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //abrir la actividad de menu principal
                Intent intent = new Intent(activity_login.this, activity_menu.class);
                startActivity(intent);
            }
        });
    }
}
