package br.pucminas.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nomePessoa;
    EditText seuNome;
    Button btnNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomePessoa= findViewById(R.id.nomepessoa);
         btnNome = findViewById(R.id.btnNome);
         seuNome = findViewById(R.id.seuNome);
    }

    public void onClick (View V){

          nomePessoa.setText(seuNome.getText().toString());

    }


}