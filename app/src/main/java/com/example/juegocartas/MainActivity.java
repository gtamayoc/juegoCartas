package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_facil, btn_medio, btn_dificil;
    String diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_facil = findViewById(R.id.button);
        btn_medio = findViewById(R.id.button2);
        btn_dificil = findViewById(R.id.button3);



        btn_facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diff="Facil";
                Intent i = new Intent(MainActivity.this,  Dificultad.class );
                i.putExtra("dificultad", diff);
                startActivity(i);
            }
        });

        btn_medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diff="Medio";
                Intent i = new Intent(MainActivity.this,  Dificultad.class );
                i.putExtra("dificultad", diff);
                startActivity(i);
            }
        });

        btn_dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diff="Dificil";
                Intent i = new Intent(MainActivity.this,  Dificultad.class );
                i.putExtra("dificultad", diff);
                startActivity(i);
            }
        });
    }
}