package com.example.aula01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // A classe R é muito importante no Android Studio.
        // Tudo esta declarado na classe R.
        // A classe R concentra toda nossa aplicacao, so precisamos referenciar.

        // instancia dos elementos
        Button btn = findViewById(R.id.button);
        TextView tv_nome= findViewById(R.id.tv_nome);
        EditText et_nome= findViewById(R.id.et_nome);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tv_nome.setText(et_nome.getText());
            }
        });
    }


}