package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dificultad extends AppCompatActivity {

    String dificultad;
    TextView dificultad1,Tot_movimientos, pares_restantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);

        int total_movimientos = 0;
        int pares_restantes1 = 0;
        Bundle bundle = getIntent().getExtras();
        dificultad=bundle.getString("dificultad");

        if(dificultad.equals("Facil")){
            pares_restantes1 = 8;
        }else if(dificultad.equals("Medio")){
            pares_restantes1 = 12;
        }else{
            pares_restantes1 = 15 ;
        }

        dificultad1 =findViewById(R.id.dificultad);
        pares_restantes=findViewById(R.id.textView9);
        Tot_movimientos= findViewById(R.id.textView99);
        Tot_movimientos.setText(""+total_movimientos);
        pares_restantes.setText(""+pares_restantes1);
        dificultad1.setText(dificultad);

    }
}