package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mydb.dao.ProdutoDAO;

public class CadastrarProdutosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produtos);

        Button btnCad = findViewById(R.id.btCad);
        EditText nome = findViewById(R.id.etNomeProduto);
        EditText desc = findViewById(R.id.etdescProduto);
        EditText val = findViewById(R.id.etValorProduto);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProdutoDAO p =  new ProdutoDAO(null,
                        nome.getText().toString(),
                        desc.getText().toString(),
                        val.getText().toString(),
                        "",
                        CadastrarProdutosActivity.this);

                if(p.inserir()){
                    Intent main = new Intent(CadastrarProdutosActivity.this, MainActivity.class);
                    startActivity(main);
                }

            }
        });



    }
}