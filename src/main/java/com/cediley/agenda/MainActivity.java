package com.cediley.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cediley.agenda.ui.Activity.FormularioClienteActivity;
import com.cediley.agenda.ui.dao.ClienteDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de Clientes");

        FloatingActionButton BotaoNovoCliente = findViewById(R.id.activity_main_fab_novo_cliente);
        BotaoNovoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormularioClienteActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        ClienteDAO dao = new ClienteDAO();

        ListView listaDeClientes = findViewById(R.id.activity_main_lista_de_clientes);
        listaDeClientes.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));

    }
}