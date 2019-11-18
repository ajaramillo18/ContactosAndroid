package com.coursera.contactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {


    EditText descripcion;
    EditText name;
    EditText phone;
    CalendarView fecha;
    EditText email;
    long date = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         descripcion = (EditText) findViewById(R.id.DescripcionTextId);
         name = (EditText) findViewById(R.id.NameTextId);
         phone = (EditText) findViewById(R.id.PhoneTextId);
         fecha = (CalendarView) findViewById(R.id.calendarView);
         email = (EditText) findViewById(R.id.EmailTextId);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            descripcion.setText(bundle.getString("descripcion"));
            name.setText(bundle.getString("name"));
            phone.setText(bundle.getString("phone"));
           // fecha.setDate(bundle.getLong("fecha"));
            email.setText(bundle.getString("email"));
        }

        Button buttonAdd = (Button) findViewById(R.id.ButtonAddId);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentContacto = new Intent(MainActivity.this, ConfirmarDatos.class);
                Log.i("MainActivity", "fecha : " +date);
                intentContacto.putExtra("descripcion", descripcion.getText().toString());
                intentContacto.putExtra("name", name.getText().toString());
                intentContacto.putExtra("phone", phone.getText().toString());
                intentContacto.putExtra("fecha", date);
                intentContacto.putExtra("email", email.getText().toString());

                startActivity(intentContacto);

            }
        });
        fecha.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                date = (new Date(year,month,day)).getTime();// TODO Auto-generated method stub
            }
        });


    }

}