package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double num1, num2, res;
    TextView tv_resultado;
    EditText et_valor1;
    EditText et_valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_soma =findViewById(R.id.btn_soma);
        Button btn_sub =findViewById(R.id.btn_sub);
        Button btn_mul =findViewById(R.id.btn_mul);
        Button btn_div =findViewById(R.id.btn_div);

        // devemos associar os elementos da tela aos objetos dentro do onCreate para
        // garantir que os elementos sejam criados e assim associados
        TextView tv_resultado =findViewById(R.id.tv_resultado);
        EditText et_valor1 =findViewById(R.id.et_valor1);
        EditText et_valor2 =findViewById(R.id.et_valor2);

        // FORMA 1: DENTRO DO ONCREAT
        btn_soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(et_valor1.getText().toString());
                num2=Double.parseDouble(et_valor2.getText().toString());
                res=num1+num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(et_valor1.getText().toString());
                num2=Double.parseDouble(et_valor2.getText().toString());
                res=num1-num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(et_valor1.getText().toString());
                num2=Double.parseDouble(et_valor2.getText().toString());
                res=num1*num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(et_valor1.getText().toString());
                num2=Double.parseDouble(et_valor2.getText().toString());
                res=num1/num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });
    }

    /*
    // FORMA 2: METODOS + onClick
    // Metodos para associar os elementos do layout
    // Os eventos sao associados aos botoes pelo XML onClick
    public void somar(View v){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1+num2;
        tv_resultado.setText(String.valueOf(res));
    }
    public void sub(View v){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1-num2;
        tv_resultado.setText(String.valueOf(res));
    }
    public void mul(View v){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1*num2;
        tv_resultado.setText(String.valueOf(res));
    }
    public void div(View v){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1/num2;
        tv_resultado.setText(String.valueOf(res));
    }
    */

    /*
    public void somar(){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1+num2;
        tv_resultado.setText(String.valueOf(res));
    }
    public void sub(){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1-num2;
        tv_resultado.setText(String.valueOf(res));
    }
    public void mul(){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1*num2;
        tv_resultado.setText(String.valueOf(res));
    }
    public void div(){
        num1=Double.parseDouble(et_valor1.getText().toString());
        num2=Double.parseDouble(et_valor2.getText().toString());
        res=num1/num2;
        tv_resultado.setText(String.valueOf(res));
    }

    // METODO 3: IDENTIFICANDO BOTAO E DISPARANDO METODO CORRESPONDENTE
    public void opera(View v){
        // podemos usar if ou switch case
        if (v.getId() == R.id.btn_soma) {
            somar();
        } else if (v.getId() == R.id.btn_sub) {
            sub();
        } else if (v.getId() == R.id.btn_mul) {
            mul();
        }else {
            div();
        }
    }
    */
}