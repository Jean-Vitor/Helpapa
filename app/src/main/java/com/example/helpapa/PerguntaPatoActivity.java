package com.example.helpapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class PerguntaPatoActivity extends AppCompatActivity {

    private Button buttonAdivinhar;
    private EditText inputMin;
    private EditText inputMax;
    private String stringMin;
    private String stringMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pato);

        buttonAdivinhar = findViewById(R.id.buttonAdivinhar);
        buttonAdivinhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getApplicationContext(), ResultadoPatoActivity.class);
                inputMin = findViewById(R.id.inputMin);
                inputMax = findViewById(R.id.inputMax);
                stringMin = inputMin.getText().toString();
                stringMax = inputMax.getText().toString();

                if(!(stringMax.equals("")) || !(stringMin.equals(""))){
                    int min = Integer.parseInt(stringMin);
                    int max = Integer.parseInt(stringMax);

                    if (min >= max) {
                        Toast.makeText(getApplicationContext(), "O número minímo não pode ser igual ou maior que o número máximo!", Toast.LENGTH_LONG).show();
                    } else {
                        Random rand = new Random();
                        int randomNum = rand.nextInt((max - min) + 1) + min;

                        intent.putExtra("numeroSorteado", randomNum);
                        startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Por favor, preencha os dados corretamente!", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
