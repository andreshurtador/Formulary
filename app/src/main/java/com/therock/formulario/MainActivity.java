package com.therock.formulario;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    private String CiudadElegida, User, Password, Repetir, Email, Genero, Actividades = "", Fecha;
    private Spinner sCiudades;
    private static final String TAG = "MainAcivity";
    private DatePickerDialog.OnDateSetListener dFecha;

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
        sCiudades = (Spinner) findViewById(R.id.sCiudades);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CiudadElegida = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert, dFecha, año, mes, dia);
                dialog.show();
            }
        });

        dFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
                mes = mes + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + mes + "/" + dia + "/" + año);
                String fecha = " " + mes + "/" + dia + "/" + año;
                tFecha.setText(fecha);
            }
        };
    }


    public void Aceptar(View view) {
        User = eUser.getText().toString();
        Password = ePassword.getText().toString();
        Repetir = eRepetir.getText().toString();
        Email = eEmail.getText().toString();
        Fecha = tFecha.getText().toString();
        Actividades = "";

        if (cCorrer.isChecked()) {
            Actividades += "Correr ";
        }
        if (cCaminar.isChecked()) {
            Actividades += "Caminar ";
        }
        if (cTrotar.isChecked()) {
            Actividades += "Trotar ";
        }
        if (cSaltar.isChecked()) {
            Actividades += "Saltar ";
        }

        if (rMasculino.isChecked()) {
            Genero = "Masculino";
        } else {
            Genero = "Femenino";
        }

        if (!TextUtils.isEmpty(User) && !TextUtils.isEmpty(Password) &&
                !TextUtils.isEmpty(Repetir) && !TextUtils.isEmpty(Email) &&
                !TextUtils.isEmpty(Fecha) && !TextUtils.isEmpty(CiudadElegida) && !TextUtils.isEmpty(Actividades) && !TextUtils.isEmpty(Genero)) {
            if (Password.equals(Repetir)) {
                tInformacion.setText("Usuario: " + User + " \nPassword: " + Password + " \nE-mail: " + Email + " \nFecha de nacimiento : " + Fecha +
                        " \nSexo: " + Genero + " \nActividad(es): " + Actividades + " \nCiudad: " + CiudadElegida);
            } else {
                tInformacion.setText("Porfavor verifique que los password cocincidan !");
                ePassword.setText("");
                eRepetir.setText("");
                ePassword.setError("Digite nuevamente");
            }
        } else {
            tInformacion.setText("Faltan campos por llenar");
            if (TextUtils.isEmpty(User)) {
                tInformacion.setText("Faltan campos por llenar" + "\nSeleccione actividad");
            }
            if (TextUtils.isEmpty(Password)) {
                tInformacion.setText("Faltan campos por llenar" + "\nSeleccione actividad");
            }
            if (TextUtils.isEmpty(Repetir)) {
                tInformacion.setText("Faltan campos por llenar" + "\nSeleccione actividad");
            }
            if (TextUtils.isEmpty(Email)) {
                tInformacion.setText("Faltan campos por llenar" + "\nSeleccione actividad");
            }
            if (TextUtils.isEmpty(Fecha)) {
                tInformacion.setText("Faltan campos por llenar" + "\nSeleccione actividad");
            }
            if (TextUtils.isEmpty(Actividades)) {
                tInformacion.setText("Faltan campos por llenar" + "\nSeleccione actividad");
            }
        }
    }
}




