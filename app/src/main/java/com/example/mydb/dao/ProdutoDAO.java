package com.example.mydb.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydb.DBHelper.DBHelper;

public class ProdutoDAO {

    private Integer id;
    private String nome;
    private String descricao;
    private String foto;
    private String valor;
    private DBHelper dbhelper;
    private SQLiteDatabase database;

    public ProdutoDAO(Context ctx){
        dbhelper = new DBHelper(ctx);
        database = dbhelper.getWritableDatabase();
    }

    public ProdutoDAO(Integer id, String nome, String descricao, String valor, String foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.valor = valor;
    }

    public ProdutoDAO(Integer id, String nome, String descricao, String valor, String foto, Context ctx) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.valor = valor;

        dbhelper = new DBHelper(ctx);
        database = dbhelper.getWritableDatabase();
    }

    public boolean inserir(){
        ContentValues cv = new ContentValues();
        cv.put("nome", this.nome);
        cv.put("descricao", this.descricao);
        cv.put("foto", this.foto);
        cv.put("valor", this.valor);

        long ret = database.insert("produto",
                null,cv);

        if(ret > 0){
            return true;
        }
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean insert(){
        return false;
    }

    public boolean delete(){
        return false;
    }

    public Cursor ListarProduto(){
        String sql = "SELECT id as _id, nome FROM produto;";
        Cursor c = database.rawQuery(sql, null);

        if (c != null){
            c.moveToFirst();
        }
        return c;
    }

}
