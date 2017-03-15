package com.example.android.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    //Declaramos variables...........
    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i;//Para pasar de una actividad a otra
    private Bundle b;//Mantiene los objetos encapsulados


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturamos la cajas
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);

        //Creamos el objeto intent
        i = new Intent(this, Saludo.class);

        //Creamos el objeto bundle que sirve para encapsular
        b = new Bundle();
        // cajaMensaje = (TextView)findViewById(R.id.lblMensaje);

    }

    public void saludar(View v){
        String nomb, apell;

        if(validar()==true) {
            //Tomo el Valor que la persona ingresa...
            nomb = cajaNombre.getText().toString();
            apell = cajaApellido.getText().toString();

            //Encapsulo los datos previamente tomados...
            b.putString("Nombre", nomb);
            b.putString("Apellido", apell);

            //Le paso al intent todos los datos en forma encapsulada con el bundle....
            i.putExtras(b);

            //Arranco la actividad que el intent me diga...
            startActivity(i);

            // aux = cajaNombre.getText().toString();
            // cajaMensaje.setText(getResources().getString(R.string.parte_saludo)+" "+aux);
        }

    }

    public boolean validar(){
        if(cajaNombre.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el nombre", Toast.LENGTH_SHORT);
            cajaNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaApellido.getText().toString().isEmpty()){
            //Toast.makeText(this,"Digite por favor el apellido", Toast.LENGTH_SHORT);
            cajaApellido.setError(getResources().getString(R.string.error_2));
            return false;
        }
        return  true;
    }



}
