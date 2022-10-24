package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarProdutosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produtos);

        Button btnCad = findViewById(R.id.btCad);
        EditText nome = findViewById(R.id.etNomeProduto);
        EditText descricao = findViewById(R.id.etdescProduto);
        EditText valor = findViewById(R.id.etValorProduto);



    }
}