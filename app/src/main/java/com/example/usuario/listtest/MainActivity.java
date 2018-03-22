package com.example.usuario.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nombre;
    private ListView listView;
    private List<String> lista = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lista);
        lista.add("paco");
        lista.add("antonio");
        lista.add("manolo");
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adapter);
        findViewById(R.id.AltaNombre).setOnClickListener(this);
        findViewById(R.id.Borrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre=findViewById(R.id.NombreEditText);
                if (lista.contains(nombre.getText().toString())){
                    lista.remove(nombre.getText().toString());
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this,"no existe el elemento",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        nombre = findViewById(R.id.NombreEditText);
        lista.add(nombre.getText().toString());
        adapter.notifyDataSetChanged();

    }

}
