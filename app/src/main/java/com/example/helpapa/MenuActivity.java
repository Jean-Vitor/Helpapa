package com.example.helpapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button buttonPanda;
    private Button buttonPato;
    private Button buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonPanda = findViewById(R.id.buttonPanda);
        buttonPato = findViewById(R.id.buttonPato);
        buttonInfo = findViewById(R.id.buttonInfo);


        buttonPanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntaPandaActivity.class);
                startActivity(intent);
            }
        });

        buttonPato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getApplicationContext(), PerguntaPatoActivity.class);
                startActivity(intent);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                //TODO
                //Criar a tela de informações
                Toast.makeText(getApplicationContext(), "Você ainda n fez vagabundo", Toast.LENGTH_LONG).show();
            }
        });

    }
}
