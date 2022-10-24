package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.example.mydb.dao.ProdutoDAO;

public class MainActivity extends AppCompatActivity {

    ListView lvProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProdutos = findViewById(R.id.ListviewProdutos);

        lvProdutos.setEmptyView(findViewById(R.id.tvEmpty));

        ProdutoDAO pDao = new ProdutoDAO(MainActivity.this);
        Cursor c = pDao.ListarProduto();

        //Cursor cc - new ProdutoDAO(this).ListarProduto();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.lista_produtos,
                c,
                new String[]{"_id", "nome"},
                new int[]{R.id.id, R.id.nome}, 0);

        lvProdutos.setAdapter(adapter);
    }
}