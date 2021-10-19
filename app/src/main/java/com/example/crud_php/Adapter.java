package com.example.crud_php;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Usuarios> {

Context context;
List<Usuarios> arrayUsuarios;

    public Adapter(@NonNull Context context, List<Usuarios> arrayUsuarios) {
        super(context, R.layout.list_usuarios,arrayUsuarios);
        this.context =context;
        this.arrayUsuarios =arrayUsuarios;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_usuarios,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(arrayUsuarios.get(position).getId());
        tvName.setText(arrayUsuarios.get(position).getNombre());

        return view;
    }
}
