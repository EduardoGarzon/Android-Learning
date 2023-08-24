package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.*;
public class MainActivity extends AppCompatActivity {

    // Criando variaveis globais
    EditText et_nome, et_telefone;
    Button btn_gravar, btn_consultar, btn_fechar;


    // static, mesmo endereco de memoria, basta chamar;
    CxMsg msg;
    //CxMsg msg = new CxMsg(); // Nao static

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associando as os objetos aos elementos do layout
        et_nome = findViewById(R.id.et_nome);
        et_telefone = findViewById(R.id.et_telefone);

        btn_gravar = findViewById(R.id.btn_gravar);
        btn_consultar = findViewById(R.id.btn_consultar);
        btn_fechar = findViewById(R.id.btn_fechar);

        // abrir e fechar o DB
        BancoDados.abrirDB(this);
        BancoDados.abrirTabela(this);
        BancoDados.fecharDB();
    }

    // Insercao dos Registros
    public void inserirRegistro(View view){
        String st_nome, st_fone;
        st_nome = et_nome.getText().toString();
        st_fone = et_telefone.getText().toString();
        if (st_nome == "" || st_fone == ""){
            msg.mostrar("Campos nao podem estar vazios!", this);
            return;
        }
        BancoDados.inserirRegistro(this, st_nome, st_fone);
        et_nome.setText(null);
        et_telefone.setText(null);
    }

    // Funcao para abrir tela Consulta
    public void abrir_TelaConsulta(View view){
        Intent it_telaconsulta = new Intent(this, TelaConsulta.class);
        startActivity(it_telaconsulta);
    }

    // Metodo para fechar tela main
    public void fecharTela(View view){
        this.finish();
    }


}