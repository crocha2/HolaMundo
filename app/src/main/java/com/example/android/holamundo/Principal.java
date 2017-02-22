package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private TextView cajaMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaMensaje = (TextView)findViewById(R.id.lblMensaje);

    }

    public void saludar(View v){
        String aux;
        aux = cajaNombre.getText().toString();
        cajaMensaje.setText(getResources().getString(R.string.parte_saludo)+" "+aux);
    }

}
