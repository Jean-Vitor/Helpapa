package com.example.helpapa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoPatoActivity extends AppCompatActivity {

    private TextView inputResultado;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadopato);

        buttonVoltar = findViewById(R.id.buttonVoltar);
        inputResultado = findViewById(R.id.inputResultado);

        Bundle dados = getIntent().getExtras();
        int numeroSorteado = dados.getInt("numeroSorteado");

        inputResultado.setText("O número sorteado foi: " + numeroSorteado);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
