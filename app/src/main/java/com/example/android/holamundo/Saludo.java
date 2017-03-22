package com.example.android.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private Bundle b;
    private String aux, nomb, apell, genero, estado_civil;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        saludo = (TextView)findViewById(R.id.txtSaludo);
        b = getIntent().getExtras();
        nomb = b.getString("Nombre");
        apell = b.getString("Apellido");
        genero = b.getString("Genero");
        estado_civil = b.getString("Estado_civil");
        res = this.getResources();

        //Mensaje de saludo bilingue........
        aux = res.getString(R.string.parte_saludo)+" "+nomb+" "+apell+" "+res.getString(R.string.parte_saludo2);
        aux = aux+"\n"+res.getString(R.string.datos);
        aux = aux+"\n\n"+res.getString(R.string.nombre)+": "+nomb;
        aux = aux+"\n\n"+res.getString(R.string.apellido)+": "+apell;
        aux = aux+"\n\n"+res.getString(R.string.genero)+": "+genero;
        aux = aux+"\n\n"+res.getString(R.string.estado_civil)+": "+estado_civil;

        saludo.setText(aux);

    }
}
