package com.example.jogodavelha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int matriz[][] = new int[3][3];
    private Button b[] = new Button[9];

    private int quantidade, plc1, plc2, verificar, verificar2;
    private int jogador;
    private String ganhador;
    private String jogador1;
    private String jogador2;

    TextView tv_jogador1, tv_jogador2, tv_placar1, tv_placar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b[0] = findViewById(R.id.btn_1);
        b[1] = findViewById(R.id.btn_2);
        b[2] = findViewById(R.id.btn_3);
        b[3] = findViewById(R.id.btn_4);
        b[4] = findViewById(R.id.btn_5);
        b[5] = findViewById(R.id.btn_6);
        b[6] = findViewById(R.id.btn_7);
        b[7] = findViewById(R.id.btn_8);
        b[8] = findViewById(R.id.btn_9);

        Button btn_jogador1 = findViewById(R.id.btn_jogador1);
        Button btn_jogador2 = findViewById(R.id.btn_jogador2);
        Button btn_newgame = findViewById(R.id.btn_newgame);

        tv_jogador1 = findViewById(R.id.tv_jogador1);
        tv_jogador2 = findViewById(R.id.tv_jogador2);
        tv_placar1 = findViewById(R.id.tv_placar1);
        tv_placar2 = findViewById(R.id.tv_placar2);

        btn_jogador1.setEnabled(false);
        btn_jogador2.setEnabled(false);
        fimJogo();

        btn_newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    btn_jogador1.setEnabled(true);
                    btn_jogador2.setEnabled(true);
                    quantidade = 1;
                    jogador = 1;
                    verificar = 0;
                    plc1 = 0;
                    plc2 = 0;
                    tv_jogador1.setText(String.valueOf("Nome jogador 1"));
                    tv_jogador2.setText(String.valueOf("Nome jogador 2"));
                    tv_placar1.setText(String.valueOf(plc1));
                    tv_placar2.setText(String.valueOf(plc2));
                    fimJogo();

            }
        });

        btn_jogador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder primeiroJogador = new AlertDialog.Builder(view.getContext());
                final EditText editText1 = new EditText(view.getContext());
                primeiroJogador.setMessage("INFORME O NOME DO JOGADOR 1: ");
                primeiroJogador.setTitle("JOGADOR 1");
                primeiroJogador.setView(editText1);
                primeiroJogador.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jogador1 = editText1.getText().toString();
                        tv_jogador1.setText(String.valueOf(jogador1));
                        tv_placar1.setText(String.valueOf(plc1));
                        verificar++;
                        if (verificar >= 2) {
                            limparJogo();
                        }
                        btn_jogador1.setEnabled(false);
                    }
                });
                primeiroJogador.create();
                primeiroJogador.show();
            }
        });

        btn_jogador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder segundoJogador = new AlertDialog.Builder(view.getContext());
                final EditText editText2 = new EditText(view.getContext());
                segundoJogador.setMessage("INFORME O NOME DO JOGADOR 2: ");
                segundoJogador.setTitle("JOGADOR 2");
                segundoJogador.setView(editText2);
                segundoJogador.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jogador2 = editText2.getText().toString();
                        tv_jogador2.setText(String.valueOf(jogador2));
                        tv_placar2.setText(String.valueOf(plc2));
                        verificar++;
                        if (verificar >= 2) {
                            limparJogo();
                        }
                        btn_jogador2.setEnabled(false);
                    }
                });
                segundoJogador.create();
                segundoJogador.show();
            }
        });

        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[0], 0, 0);
            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[1], 0, 1);
            }
        });
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[2], 0, 2);
            }
        });
        b[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[3], 1, 0);
            }
        });
        b[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[4], 1, 1);
            }
        });
        b[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[5], 1, 2);
            }
        });
        b[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[6], 2, 0);
            }
        });
        b[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[7], 2, 1);
            }
        });
        b[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarJogadores(b[8], 2, 2);
            }
        });

    }

    // verificar jogadores na jogada
    public void checarJogadores(Button b, int x, int y) {
        if (jogador == 1) {
            matriz[x][y] = 1;
            b.setText("X");
            jogador = 2;
            ganhador = jogador1;
            checarJogada(1);
        } else {
            matriz[x][y] = 2;
            b.setText("O");
            jogador = 1;
            ganhador = jogador2;
            checarJogada(2);
        }
        quantidade++;
    }

    public boolean checarVitoria(int x){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == x && matriz[i][1] == x && matriz[i][2] == x) {
                return true;
            }
            if (matriz[0][i] == x && matriz[1][i] == x && matriz[2][i] == x) {
                return true;
            }
            if (matriz[0][0] == x && matriz[1][1] == x && matriz[2][2] == x) {
                return true;
            }
            if (matriz[0][2] == x && matriz[1][1] == x && matriz[2][0] == x) {
                return true;
            }
        }
        return false;
    }

    public void checarJogada(int x){
        if (checarVitoria(x) == true) {
            AlertDialog.Builder alertaVencedor = new AlertDialog.Builder(this);
            alertaVencedor.setTitle("VENCEDOR");
            alertaVencedor.setMessage("O jogador " + ganhador + " venceu a partida!");
            alertaVencedor.setIcon(android.R.drawable.star_on);
            alertaVencedor.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (ganhador == jogador1) {
                        plc1++;
                        tv_placar1.setText(String.valueOf(plc1));
                    } else {
                        plc2++;
                        tv_placar2.setText(String.valueOf(plc2));
                    }

                    limparJogo();
                }
            });
            alertaVencedor.create();
            alertaVencedor.show();
        }
    }

    public void fimJogo(){
        for (int i = 0; i < 9; i++) {
            b[i].setEnabled(false);
            b[i].setText("");
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                matriz[x][y] = 0;
            }
        }
        jogador = 1;
        ganhador = "";
    }

    public void limparJogo() {
        for (int i = 0; i < 9; i++) {
            b[i].setEnabled(true);
            b[i].setText("");
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                matriz[x][y] = 0;
            }
        }
        jogador = 1;
        ganhador = "";
    }
}