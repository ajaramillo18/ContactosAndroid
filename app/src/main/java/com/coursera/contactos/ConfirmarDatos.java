package com.coursera.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ConfirmarDatos extends AppCompatActivity {

    TextView descripcion;
    TextView name;
    TextView phone ;
    TextView fecha;
    TextView email;
    long longFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);



         descripcion = (TextView) findViewById(R.id.textViewDescripcion);
         name = (TextView) findViewById(R.id.textViewNombre);
         phone = (TextView) findViewById(R.id.textViewTelefono);
         fecha = (TextView) findViewById(R.id.textViewFecha);
         email = (TextView) findViewById(R.id.textViewEmail);

        Bundle bundle = getIntent().getExtras();

            //setear la fecha
            Date date = new Date(bundle.getLong("fecha"));
            longFecha   =bundle.getLong("fecha");
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy");
            String currentDate = sd.format(date);

            fecha.setText(currentDate);

           descripcion.setText(bundle.getString("descripcion"));
           name.setText(bundle.getString("name"));
           phone.setText(bundle.getString("phone"));
           email.setText(bundle.getString("email"));

                Log.i("XXXXXXXX",""+bundle.getLong("fecha"));

        Button buttonAdd = (Button) findViewById(R.id.buttonEditar);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intentContacto = new Intent(ConfirmarDatos.this, MainActivity.class);

                intentContacto.putExtra("descripcion", descripcion.getText().toString());
                intentContacto.putExtra("name", name.getText().toString());
                intentContacto.putExtra("phone", phone.getText().toString());
                intentContacto.putExtra("fecha", longFecha);
                intentContacto.putExtra("email", email.getText().toString());

                startActivity(intentContacto);

            }
        });






    }
}
