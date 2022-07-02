package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Dificultad extends AppCompatActivity {

    String dificultad;
    TextView dificultad1,Tot_movimientos, pares_restantes;
    ImageView p15,p25,p35,p45,p55,p65;
    ImageView p11,p12,p13,p14,p21,p22,p23,p24,p31,p32,p33,p34,p41,p42,p43,p44,p51,p52,p53,p54,p61,p62,p63,p64;
    private static final Random rgenerador = new Random();
    String [] imagenes = {"pk","pkx","pkxx","pkxxx","pkxxxx","pkxxxxx","pkxxxxx"};

    static final Integer[] imagenesID = {R.drawable.pk, R.drawable.pkx, R.drawable.pkxx,R.drawable.pkxxx,R.drawable.pkxxxx,R.drawable.pkxxxxxx};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);


        Bundle bundle = getIntent().getExtras();
        dificultad=bundle.getString("dificultad");
        int total_movimientos = 0;
        int pares_restantes1 = 0;
        inicializacion();

        ImageView [] prueba= {p11,p12,p13,p14,p21,p22,p23,p24,p31,p32,p33,p34,p41,p42,p43,p44,p51,p52,p53,p54,p61,p62,p63,p64,p15,p25,p35,p45,p55,p65};

        if(dificultad.equals("Facil")){
            ImageView [] prueba3= {p11,p12,p13,p14,p21,p22,p23,p24,p31,p32,p33,p34,p41,p42,p43,p44};
            pares_restantes1 = 8;
            int pares_restantes2 = pares_restantes1 + pares_restantes1;
            p15.setVisibility(View.GONE);
            p25.setVisibility(View.GONE);
            p35.setVisibility(View.GONE);
            p45.setVisibility(View.GONE);
            p55.setVisibility(View.GONE);
            p65.setVisibility(View.GONE);
            p51.setVisibility(View.GONE);
            p52.setVisibility(View.GONE);
            p53.setVisibility(View.GONE);
            p54.setVisibility(View.GONE);
            p61.setVisibility(View.GONE);
            p62.setVisibility(View.GONE);
            p63.setVisibility(View.GONE);
            p64.setVisibility(View.GONE);
            aleatorio(0,pares_restantes1);

            for(int i=0 ; i<pares_restantes2 ; i++){
                    int resource = imagenesID[rgenerador.nextInt(imagenesID.length)];
                    ImageView prueba2= prueba3[i];
                    prueba2.setImageResource(resource);
            }
//            p11.setImageResource(resource);
//            p12.setImageResource(resource);
//            p13.setImageResource(resource);
//            p14.setImageResource(resource);
//            p21.setImageResource(resource);
//            p22.setImageResource(resource);
//            p23.setImageResource(resource);
//            p24.setImageResource(resource);
//            p31.setImageResource(resource);
//            p32.setImageResource(resource);
//            p33.setImageResource(resource);
//            p34.setImageResource(resource);
//            p41.setImageResource(resource);
//            p42.setImageResource(resource);
//            p43.setImageResource(resource);
//            p44.setImageResource(resource);
        }else if(dificultad.equals("Medio")){
            pares_restantes1 = 12;
            p15.setVisibility(View.GONE);
            p25.setVisibility(View.GONE);
            p35.setVisibility(View.GONE);
            p45.setVisibility(View.GONE);
            p55.setVisibility(View.GONE);
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

    private int prueba(Integer integer) {

        return 0;
    }


    public void inicializacion(){
        p11= findViewById(R.id.p11);
        p12= findViewById(R.id.p12);
        p13= findViewById(R.id.p13);
        p14= findViewById(R.id.p14);
        p15= findViewById(R.id.p15);
        p21= findViewById(R.id.p21);
        p22= findViewById(R.id.p22);
        p23= findViewById(R.id.p23);
        p24= findViewById(R.id.p24);
        p25=findViewById(R.id.p25);
        p31= findViewById(R.id.p31);
        p32= findViewById(R.id.p32);
        p33= findViewById(R.id.p33);
        p34= findViewById(R.id.p34);
        p41= findViewById(R.id.p41);
        p42= findViewById(R.id.p42);
        p43= findViewById(R.id.p43);
        p44= findViewById(R.id.p44);
        p35=findViewById(R.id.p35);
        p45=findViewById(R.id.p45);
        p55=findViewById(R.id.p55);
        p65=findViewById(R.id.p65);
        p61= findViewById(R.id.p61);
        p62= findViewById(R.id.p62);
        p63= findViewById(R.id.p63);
        p64= findViewById(R.id.p64);
        p51= findViewById(R.id.p51);
        p52= findViewById(R.id.p52);
        p53= findViewById(R.id.p53);
        p54= findViewById(R.id.p54);

    }


    public void aleatorio(int tipo, int cartas){
        switch (tipo){
            case 0:
                Random r = new Random();
                int valorDado = r.nextInt(9)+1;
                int [] valores = new int[cartas];
                valores[0] = valorDado;
                unico(valores, valorDado);
                if(unico(valores, valorDado) != 0){
                    valores[0] = valorDado;
                }
            case 1:
            case 2:
            default:
                break;
        }



    }

    public int unico(int [] valores, int valor){
        for(int i=0 ; i>=valores.length; i++){
            while (valores[i]!=valor){
                return 0;
            }
        }
        Random r = new Random();
        int valorDado = r.nextInt(9)+1;
        return valorDado;
    }




    public int [] sinRepetir(){
        int n=6;
        int k=n;  //auxiliar;
        int[] numeros=new int[n];
        int[] resultado=new int[n];
        Random rnd=new Random();
        int res;

        for(int i=0;i<n;i++){
            numeros[i]=i+1;
        }

        for(int i=0;i<n;i++){
            res=rnd.nextInt(k);
            resultado[i]=numeros[res];
            numeros[res]=numeros[k-1];
            k--;

        }

        return numeros;
    }
}