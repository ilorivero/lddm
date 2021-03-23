package br.pucminas.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerInterface {

    RecyclerView meuRecyclerView;
    LinearLayoutManager meuLayoutManager;
    MeuAdapter adapter;
    private List<Contatos> listaContatos = new ArrayList<>();
    EditText editNome, editEmail,editFone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editFone = findViewById(R.id.editFone);

        meuRecyclerView = (RecyclerView) findViewById(R.id.meuRecyclerView);
        meuLayoutManager = new LinearLayoutManager(this);
        meuRecyclerView.setLayoutManager(meuLayoutManager);
        adapter = new MeuAdapter(this, listaContatos, this);
        meuRecyclerView.setAdapter(adapter);



    }

    public void onClick(View v) {
        Contatos contato = new Contatos();
        contato.setNome(editNome.getText().toString());
        contato.setTelefone(editFone.getText().toString());
        contato.setEmail(editEmail.getText().toString());
        listaContatos.add(contato);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(Object object) {
        Contatos contato = (Contatos) object;
        String nome = contato.getNome();
        String email = contato.getEmail();
        String telefone = contato.getTelefone();
        editNome.setText(nome);
        editEmail.setText(email);
        editFone.setText(telefone);
    }
}