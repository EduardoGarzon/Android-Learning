package com.example.aula08;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Criacao das variaveis e objetos
    double vcaneca, vprato, vgarfo, vfaca, vtotal;
    EditText et_caneca, et_prato, et_garfo, et_faca;
    CheckBox cb_caneca, cb_prato, cb_garfo, cb_faca;
    TextView tv_resultado;
    Button btn_calcular, btn_tela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associando as variaveis aos elementos
        et_caneca=findViewById(R.id.et_canecas);
        et_prato=findViewById(R.id.et_pratos);
        et_garfo=findViewById(R.id.et_garfos);
        et_faca=findViewById(R.id.et_facas);

        cb_caneca=findViewById(R.id.cb_canecas);
        cb_prato=findViewById(R.id.cb_pratos);
        cb_garfo=findViewById(R.id.cb_garfos);
        cb_faca=findViewById(R.id.cb_facas);

        btn_calcular=findViewById(R.id.btn_calcular);
        btn_tela2=findViewById(R.id.btn_tela2);

        tv_resultado=findViewById(R.id.tv_resultado);

        // Atribuindo valores R$
        vcaneca = 0.25;
        vprato  = 0.20;
        vgarfo  = 0.10;
        vfaca   = 0.10;

        // Concatenando os valores R$ aos elementos
        cb_caneca.setText(cb_caneca.getText().toString() + vcaneca);
        cb_prato.setText(cb_prato.getText().toString() + vprato);
        cb_garfo.setText(cb_garfo.getText().toString() + vgarfo);
        cb_faca.setText(cb_faca.getText().toString() + vfaca);
    }

    // METODO + onClick para o botao calcular
    public void Calcular(View view){
        vtotal = 0.0;
        if (cb_caneca.isChecked()){
            vtotal += vcaneca * Double.parseDouble(et_caneca.getText().toString());
        }
        if (cb_prato.isChecked()){
            vtotal += vprato * Double.parseDouble(et_prato.getText().toString());
        }
        if (cb_garfo.isChecked()){
            vtotal += vgarfo * Double.parseDouble(et_garfo.getText().toString());
        }
        if (cb_faca.isChecked()){
            vtotal += vfaca * Double.parseDouble(et_faca.getText().toString());
        }
        tv_resultado.setText("Valor Total: R$" + vtotal);
        // Caixa de Mensagem: Notificacao Toast
        Toast.makeText(this, "Valor da Locacao Calculado.", Toast.LENGTH_SHORT).show();
        // Caixa de Mensagem: AlertDialog
        AlertDialog.Builder cxMsg = new AlertDialog.Builder(this);
        cxMsg.setMessage("Valor da Locacao Calculado.");
        cxMsg.setNeutralButton("OK", null);
        cxMsg.show();
    }

    // Metodo para abertura, criacao, instancia e chamada da nova tela
    // Cada tela é um Activity
    public void abrir_Tela2(View view){
        // Intent carrega o activity, abre a nova janela e vai empilhando esse processo
        Intent it_tela2 = new Intent(this, tela_sobre.class);
        // passagem dos parametros
        it_tela2.putExtra("p_nome", "Luiz");
        it_tela2.putExtra("p_vtotal", vtotal);
        startActivity(it_tela2);



        // apenas troca a activity relacionada ao layout, nao carrega a activity, troca o layout
        //setContentView(R.layout.activity_tela_sobre);
    }
}