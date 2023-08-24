package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.*;
public class TelaConsulta extends AppCompatActivity {

    // Criacao das variaveis globais
    EditText et_nome_consulta, et_telefone_consulta;
    Button btn_anterior, btn_proximo, btn_voltar_consulta;

    SQLiteDatabase db=null;
    Cursor cursor;

    CxMsg msg = new CxMsg();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta);

        // Associacao dos objetos com os elementos do layout
        et_nome_consulta = findViewById(R.id.et_nome_consulta);
        et_telefone_consulta = findViewById(R.id.et_telefone_consulta);

        btn_anterior = findViewById(R.id.btn_anterior);
        btn_proximo = findViewById(R.id.btn_proximo);
        btn_voltar_consulta = findViewById(R.id.btn_voltar_consulta);

        cursor = BancoDados.buscarDados(this);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            mostrarDados();
        }else{
            msg.mostrar("Nenhum Registro Encontrado!", this);
        }

    }

    // Metodo para imprimir dados do DB
    @SuppressLint("Range")
    public void mostrarDados(){
        et_nome_consulta.setText(cursor.getString(cursor.getColumnIndex("nome")));
        et_telefone_consulta.setText(cursor.getString(cursor.getColumnIndex("fone")));
    }

    // Metodo para avancar registro
    public void proximoRegistro(View view){
        try {
            cursor.moveToNext();
            mostrarDados();
        } catch (Exception ex) {
            if (cursor.isAfterLast()){
                msg.mostrar("Nao existem mais registros!", this);
            }else{
                msg.mostrar("Erro ao navegar pelos registros!", this);
            }
        }

    }

    // Metodo para Volta Registro
    public void registroAnterior(View view){
        try {
            cursor.moveToPrevious();
            mostrarDados();
        } catch (Exception ex) {
            if (cursor.isBeforeFirst()){
                msg.mostrar("Nao existem mais registros!", this);
            }else{
                msg.mostrar("Erro ao navegar pelos registros!", this);
            }
        }

    }

    // Metodo para fechar tela consulta
    public void fecharTela(View view){
        this.finish();
    }
}