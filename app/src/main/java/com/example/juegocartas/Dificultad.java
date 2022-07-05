package com.example.juegocartas;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Dificultad extends AppCompatActivity {

    String dificultad;
    TextView dificultad1, Tot_movimientos, pares_restantes;
    ImageView p15, p25, p35, p45, p55, p65;
    ImageView p11, p12, p13, p14, p21, p22, p23, p24, p31, p32, p33, p34, p41, p42, p43, p44, p51, p52, p53, p54, p61, p62, p63, p64;
    private static final Random rgenerador = new Random();
    String[] imagenes = {"imagen1", "image2", "image3", "image4", "image5", "image6", "image7", "image8", "image9", "image10", "image11", "image12", "image13", "image14", "image15"};

    static final Integer[] imagenesID = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image77, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);


        Bundle bundle = getIntent().getExtras();
        dificultad = bundle.getString("dificultad");
        int total_movimientos = 0;
        int pares_restantes1 = 0;
        inicializacion();

        ImageView[] prueba = {p11, p12, p13, p14, p21, p22, p23, p24, p31, p32, p33, p34, p41, p42, p43, p44, p51, p52, p53, p54, p61, p62, p63, p64, p15, p25, p35, p45, p55, p65};

        if (dificultad.equals("Facil")) {
            ImageView[] prueba3 = {p11, p12, p13, p14, p21, p22, p23, p24, p31, p32, p33, p34, p41, p42, p43, p44};
            int[] prueba4 = {11, 11, 13, 13, 21, 21, 23, 23, 31, 31, 33, 33, 41, 41, 43, 43};
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

            int[] resourceArray = llenarArrays(pares_restantes1);
            int[] resourceArray2 = new int[pares_restantes1];
            List<int[]> lista = Arrays.asList(resourceArray);
            Collections.shuffle(lista);
            System.out.println(lista);
            lista.toArray(resourceArray2);

            for (int i = 0; i < pares_restantes2; i++) {

                if (pares_restantes1 >i) {
                    ImageView prueba2 = prueba3[i];
                    prueba2.setImageResource(resourceArray[i]);
                } else {
                    ImageView prueba2 = prueba3[i];
                    prueba2.setImageResource(resourceArray2[i-pares_restantes1]);
                }

            }
        } else if (dificultad.equals("Medio")) {




            ImageView[] prueba3 = {p11, p12, p13, p14, p21, p22, p23, p24, p31, p32, p33, p34, p41, p42, p43, p44, p51, p52, p53, p54, p61, p62, p63, p64};
            pares_restantes1 = 12;
            int pares_restantes2 = pares_restantes1 + pares_restantes1;
            p15.setVisibility(View.GONE);
            p25.setVisibility(View.GONE);
            p35.setVisibility(View.GONE);
            p45.setVisibility(View.GONE);
            p55.setVisibility(View.GONE);
            p65.setVisibility(View.GONE);
            for (int i = 0; i < pares_restantes2; i++) {
                int resource = imagenesID[rgenerador.nextInt(imagenesID.length)];
                ImageView prueba2 = prueba3[i];
                prueba2.setImageResource(resource);
                for (int j = 0; j < pares_restantes2-1; j++) {
                    int resources = imagenesID[rgenerador.nextInt(imagenesID.length)];
                }

            }
        } else {




            pares_restantes1 = 15;
            int pares_restantes2 = pares_restantes1 + pares_restantes1;
            for (int i = 0; i < pares_restantes2; i++) {
                int resource = imagenesID[rgenerador.nextInt(imagenesID.length)];
                ImageView prueba2 = prueba[i];
                prueba2.setImageResource(resource);
            }
        }

        dificultad1 = findViewById(R.id.dificultad);
        pares_restantes = findViewById(R.id.textView9);
        Tot_movimientos = findViewById(R.id.textView99);
        Tot_movimientos.setText("" + total_movimientos);
        pares_restantes.setText("" + pares_restantes1);
        dificultad1.setText(dificultad);

    }

    private int[] llenarArrays(int pares_restantes1) {
        int[] resourceArray = new int[pares_restantes1];
        for (int i = 0; i < pares_restantes1; i++) {
            int resource = imagenesID[rgenerador.nextInt(imagenesID.length)];
            if(i==0){
                resourceArray [0]=  resource;
            }
            while(verificar(resourceArray,resource)!=true)
            {
                resourceArray [i]=  resource;
            }

        }


        return resourceArray;
    }


    private boolean verificar(int[] resourceArray, int resource) {
        if (resourceArray == null) {
            return false;
        } else {
            for (int i = 0; i < resourceArray.length; i++) {
                if (resourceArray[i] == resource) {
                    return true;
                }
            }
        }
        return false;
    }


    public void inicializacion() {
        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        p13 = findViewById(R.id.p13);
        p14 = findViewById(R.id.p14);
        p15 = findViewById(R.id.p15);
        p21 = findViewById(R.id.p21);
        p22 = findViewById(R.id.p22);
        p23 = findViewById(R.id.p23);
        p24 = findViewById(R.id.p24);
        p25 = findViewById(R.id.p25);
        p31 = findViewById(R.id.p31);
        p32 = findViewById(R.id.p32);
        p33 = findViewById(R.id.p33);
        p34 = findViewById(R.id.p34);
        p41 = findViewById(R.id.p41);
        p42 = findViewById(R.id.p42);
        p43 = findViewById(R.id.p43);
        p44 = findViewById(R.id.p44);
        p35 = findViewById(R.id.p35);
        p45 = findViewById(R.id.p45);
        p55 = findViewById(R.id.p55);
        p65 = findViewById(R.id.p65);
        p61 = findViewById(R.id.p61);
        p62 = findViewById(R.id.p62);
        p63 = findViewById(R.id.p63);
        p64 = findViewById(R.id.p64);
        p51 = findViewById(R.id.p51);
        p52 = findViewById(R.id.p52);
        p53 = findViewById(R.id.p53);
        p54 = findViewById(R.id.p54);

    }


    public void aleatorio(int tipo, int cartas) {
        switch (tipo) {
            case 0:
                Random r = new Random();
                int valorDado = r.nextInt(9) + 1;
                int[] valores = new int[cartas];
                valores[0] = valorDado;
                unico(valores, valorDado);
                if (unico(valores, valorDado) != 0) {
                    valores[0] = valorDado;
                }
            case 1:
            case 2:
            default:
                break;
        }


    }

    public int unico(int[] valores, int valor) {
        for (int i = 0; i >= valores.length; i++) {
            while (valores[i] != valor) {
                return 0;
            }
        }
        Random r = new Random();
        int valorDado = r.nextInt(9) + 1;
        return valorDado;
    }


    public int[] sinRepetir() {
        int n = 6;
        int k = n;  //auxiliar;
        int[] numeros = new int[n];
        int[] resultado = new int[n];
        Random rnd = new Random();
        int res;

        for (int i = 0; i < n; i++) {
            numeros[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            res = rnd.nextInt(k);
            resultado[i] = numeros[res];
            numeros[res] = numeros[k - 1];
            k--;

        }

        return numeros;
    }
}