package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class detalles extends AppCompatActivity {

    TextView tvid,tvname,tvemail,tvcontact,tvaddress;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvname = findViewById(R.id.txtname);
        tvemail = findViewById(R.id.txtemail);
        tvcontact = findViewById(R.id.txcontact);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: " + MainActivity.employeeArrayList.get(position).getId());
        tvname.setText("Name: " + MainActivity.employeeArrayList.get(position).getNombre());
        tvemail.setText("Email: " + MainActivity.employeeArrayList.get(position).getCorreo());
        tvcontact.setText("Contact: " + MainActivity.employeeArrayList.get(position).getDireccion());

    }
}