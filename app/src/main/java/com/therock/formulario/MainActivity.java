package com.therock.formulario;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText eUser, ePassword, eRepetir, eEmail;
    private RadioButton rFemenino, rMasculino;
    private CheckBox cCaminar, cCorrer, cTrotar, cSaltar;
    private Button bAceptar;
    private TextView tInformacion, tFecha;
    private String CiudadElegida= " ", User= " ", Password= " ", Repetir= " ", Email= " ", Genero= " ", Actividades = " ", Fecha= " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUser = (EditText) findViewById(R.id.eUser);
        ePassword = (EditText) findViewById(R.id.ePassword);
        eRepetir = (EditText) findViewById(R.id.eRepetir);
        eEmail = (EditText) findViewById(R.id.eEmail);
        rFemenino = (RadioButton) findViewById(R.id.rFemenino);
        rMasculino = (RadioButton) findViewById(R.id.rMasculino);
        cCaminar = (CheckBox) findViewById(R.id.cCaminar);
        cCorrer = (CheckBox) findViewById(R.id.cCorrer);
        cTrotar = (CheckBox) findViewById(R.id.cTrotar);
        cSaltar = (CheckBox) findViewById(R.id.cSaltar);
        bAceptar = (Button) findViewById(R.id.bAceptar);
        tInformacion = (TextView) findViewById(R.id.tInformacion);
        tFecha = (TextView) findViewById(R.id.tFecha);

    }

    public void Aceptar(View view) {
        User = eUser.getText().toString();
        Password = ePassword.getText().toString();
        Repetir = eRepetir.getText().toString();
        Email = eEmail.getText().toString();

        Actividades = "";


    }


}


