package com.example.aula08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class tela_sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);

        //Recebendo os parametros da Main
        // intent base atribuida
        Intent it=getIntent();
        String nome = it.getStringExtra("p_nome");
        Double valor = it.getDoubleExtra("p_vtotal", 0);

        TextView tv_valort2=findViewById(R.id.tv_valort2);
        tv_valort2.setText(nome + " | R$" + valor);
    }

    // Metodo correto de finalizar uma activity atual e voltar para a anterior
    public void voltar_tela1(View view){
        this.finish();
    }


    /*public void voltar_Tela1(View view){
        // estamos criando uma nova activity e nao voltando para a anterior
        Intent it_tela1 = new Intent(this, MainActivity.class);
        startActivity(it_tela1);
    }*/
}