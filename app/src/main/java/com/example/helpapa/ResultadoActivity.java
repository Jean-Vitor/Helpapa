package com.example.helpapa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView inputResultado;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadopanda);

        buttonVoltar = findViewById(R.id.buttonVoltar);
        inputResultado = findViewById(R.id.inputResultado);

        Bundle dados = getIntent().getExtras();
        String itemSorteado = dados.getString("itemSorteado");

        inputResultado.setText("O item sorteado foi: " + itemSorteado);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}