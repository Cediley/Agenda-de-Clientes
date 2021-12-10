package com.cediley.agenda.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cediley.agenda.MainActivity;
import com.cediley.agenda.model.Cliente;
import com.cediley.agenda.R;
import com.cediley.agenda.ui.dao.ClienteDAO;

import java.text.Normalizer;

public class FormularioClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cliente);
        setTitle("Formulario do Cliente");

       final ClienteDAO dao = new ClienteDAO();

        final EditText CampoNome = findViewById(R.id.activity_Formulario_Cliente_nome);
       final EditText CampoPhone = findViewById(R.id.activity_Formulario_Cliente_telefone);
       final EditText CampoEmail = findViewById(R.id.activity_Formulario_Cliente_email);
       final EditText CampoDescricao = findViewById(R.id.activity_Formulario_Cliente_pedido);

        Button botaoSalvar = findViewById(R.id.activity_Formulario_Cliente_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormularioClienteActivity.this, "Cliente Salvo com Sucesso! ",
                    Toast.LENGTH_SHORT).show();

                String nome = CampoNome.getText().toString();
                String telefone = CampoPhone.getText().toString();
                String email = CampoEmail.getText().toString();
                String descricao = CampoDescricao.getText().toString();

                Cliente clienteCriado = new Cliente(nome, telefone, email, descricao);
                dao.salva(clienteCriado);

                finish();
            }
        });
    }
}