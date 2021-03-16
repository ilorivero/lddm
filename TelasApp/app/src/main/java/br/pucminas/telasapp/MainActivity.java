package br.pucminas.telasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botao_segunda_tela;
    Button botao_terceira_tela;
    EditText txtURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao_segunda_tela = findViewById(R.id.button);
        botao_terceira_tela = findViewById(R.id.button2);

        botao_segunda_tela.setOnClickListener(this);
        botao_terceira_tela.setOnClickListener(this);

        txtURL = findViewById(R.id.editURL);

    }

    @Override
    public void onClick (View v){

        switch(v.getId()) {

            case R.id.button:
            String valorURL = txtURL.getText().toString();

            if (!valorURL.isEmpty() ) {

            Intent intent = new Intent(this, Tela2.class);
            intent.putExtra("MinhaURL", valorURL);
            startActivity(intent);

            }
            break;
            case R.id.button2:
            Intent intent2 = new Intent(this, Tela3.class);
            startActivity(intent2);
            break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}