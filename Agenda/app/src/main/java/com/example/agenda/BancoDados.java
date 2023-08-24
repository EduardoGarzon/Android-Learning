package com.example.agenda;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.ContextWrapper;
import android.view.View;

import static android.content.Context.MODE_PRIVATE;

public class BancoDados {

    static SQLiteDatabase db=null;
    static Cursor cursor;
    static CxMsg msg;

    // Metodo para abrir o DB
    public static void abrirDB(Activity act){
        try {
            ContextWrapper cw = new ContextWrapper(act);
            db=cw.openOrCreateDatabase("DBAGENDA", MODE_PRIVATE, null);
        }catch (Exception ex) {
            msg.mostrar("Erro ao Abrir ou Criar o DB", act);
        }
    }

    // Metodo para abrir tabela DB
    public static void abrirTabela(Activity act){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTENGER PRIMARY KEY, nome TEXT, fone TEXT)");
        }catch (Exception ex) {
            msg.mostrar("Erro ao criar tabela!", act);
        }
    }

    // Metodo para inserir Registros do DB
    public static void inserirRegistro(Activity act, String nome, String fone){
        abrirDB(act);
        try {
            db.execSQL("INSERT INTO contatos (nome, fone) VALUES ('"+nome+"', '"+fone+"')");
        } catch (Exception ex){
            msg.mostrar("Erro ao inserir registro", act);
        } finally{
            msg.mostrar("Registro Inserido com Sucesso", act);
        }
        fecharDB();
    }

    // Metodo para buscar dados no DB
    public static Cursor buscarDados(Activity act){
        abrirDB(act);
        cursor = db.query("contatos",
                new String[]{"nome", "fone"},
                null,
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        return cursor;
    }

    // Metodo para fechar DB
    public static void fecharDB(){
        db.close();
    }

}
