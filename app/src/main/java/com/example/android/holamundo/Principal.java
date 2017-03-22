package com.example.android.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    //Declaramos variables...........
    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i;//Para pasar de una actividad a otra
    private Bundle b;//Mantiene los objetos encapsulados
    private Spinner comboGenero;
    private RadioButton r1, r2, r3;
    private ArrayAdapter<String> adapter;
    private String[] opc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturamos la cajas
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);

        //Capturar el combo..
        comboGenero = (Spinner)findViewById(R.id.cmbGenero);

        //Capturar radio buton
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);


        //Creamos el objeto intent
        i = new Intent(this, Saludo.class);

        //Creamos el objeto bundle que sirve para encapsular
        b = new Bundle();
        // cajaMensaje = (TextView)findViewById(R.id.lblMensaje);


        opc = this.getResources().getStringArray(R.array.generos);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opc);

        comboGenero.setAdapter(adapter);

    }

    public void saludar(View v){
        String nomb, apell, genero, estado_civil = "";

        if(validar()==true) {
            //Tomo el Valor que la persona ingresa...
            nomb = cajaNombre.getText().toString();
            apell = cajaApellido.getText().toString();

            //Capturar el genero..

            genero = comboGenero.getSelectedItem().toString();

            //Capturar estado civil..
            if(r1.isChecked()) estado_civil = getResources().getString(R.string.soltero);
            if(r2.isChecked()) estado_civil = getResources().getString(R.string.casado);
            if(r3.isChecked()) estado_civil = getResources().getString(R.string.divorciado);


            //Encapsulo los datos previamente tomados...
            b.putString("Nombre", nomb);
            b.putString("Apellido", apell);
            b.putString("Genero", genero);
            b.putString("Estado_civil",estado_civil);


            //Le paso al intent todos los datos en forma encapsulada con el bundle....
            i.putExtras(b);

            //Arranco la actividad que el intent me diga...
            startActivity(i);

            // aux = cajaNombre.getText().toString();
            // cajaMensaje.setText(getResources().getString(R.string.parte_saludo)+" "+aux);
        }

    }

    public void borrar(View v){
        cajaNombre.setText("");
        cajaNombre.requestFocus();
        comboGenero.setSelection(0);
        r1.setChecked(true);
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
