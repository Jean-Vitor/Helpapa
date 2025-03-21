package com.example.helpapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.helpapa.model.Item;

import java.util.ArrayList;
import java.util.Random;

public class PerguntaPandaActivity extends AppCompatActivity {

    private ArrayList<Item> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button buttonAdicionar;
    private Button buttonAdivinhar;
    private ImageButton buttonVoltar;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panda);
        recyclerView = findViewById(R.id.recyclerView);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                addItem(view);
            }
        });

        items = new ArrayList<>();
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        customAdapter = new CustomAdapter(items);
        recyclerView.setAdapter(customAdapter);

        buttonAdivinhar = findViewById(R.id.buttonAdivinhar);
        buttonAdivinhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if(items.size() >= 2) {
                    Intent intent = new Intent(getApplicationContext(), ResultadoPandaActivity.class);

                    //Sorteando o item
                    Random random = new Random();
                    Item sorteado = items.get(random.nextInt(items.size()));

                    intent.putExtra("itemSorteado", sorteado.getItemName());

                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Você tem menos de dois itens na lista", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonVoltar = findViewById(R.id.btnBackPanda);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.inputItem);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            Item classItem = new Item(itemText);
            if (contemItem(classItem)){
                Toast.makeText(getApplicationContext(), "Você não pode inserir itens com nomes iguais!", Toast.LENGTH_LONG).show();
            } else {
                items.add(classItem);
                customAdapter.notifyDataSetChanged();
                input.setText("");
            }
        } else {
            Toast.makeText(getApplicationContext(), "Por favor, insira algum texto!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean contemItem(Item classItem) {
        for (Item item : items) {
            if(classItem.getItemName().equals(item.getItemName())){
                return true;
            }
        }
        return false;
    }

}