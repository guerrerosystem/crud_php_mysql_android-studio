package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class editar extends AppCompatActivity {

    EditText edId, edNombre, edCorreo, edDireccion;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edId = findViewById(R.id.id);
        edNombre = findViewById(R.id.nombre);
        edCorreo = findViewById(R.id.correo);
        edDireccion = findViewById(R.id.direccion);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        edId.setText(MainActivity.employeeArrayList.get(position).getId());
        edNombre.setText(MainActivity.employeeArrayList.get(position).getNombre());
        edCorreo.setText(MainActivity.employeeArrayList.get(position).getCorreo());
        edDireccion.setText(MainActivity.employeeArrayList.get(position).getDireccion());






    }

    public void actualizar(View view) {
        final String id = edId.getText().toString();
        final String nombre = edNombre.getText().toString();
        final String correo = edDireccion.getText().toString();
        final String direccion = edCorreo.getText().toString();







        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Actualizando....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, "https://hola.kimvccug.lucusvirtual.es/actualizar_.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(editar.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("nombre",nombre);
                params.put("correo",correo);
                params.put("direccion",direccion);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(editar.this);
        requestQueue.add(request);





    }
}