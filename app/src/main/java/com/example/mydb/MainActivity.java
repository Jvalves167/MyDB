package com.example.mydb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

        lvProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(AdapterView<?> parent, View view, int position, long ) {

                Intent it = new Intent(MainActivity.this,
                        .class);
                it.putExtra("id", id+"");
                startActivity(it);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tela_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_add:
                Intent add_menu = new Intent(this, CadastrarProdutosActivity.class);
                startActivity(add_menu);
        }

        return super.onOptionsItemSelected(item);
    }
}