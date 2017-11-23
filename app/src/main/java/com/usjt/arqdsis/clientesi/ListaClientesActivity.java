package com.usjt.arqdsis.clientesi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaClientesActivity extends Activity {
    public static final String NOME = "com.usjt.arqdsis.clientesi.nome";
    ArrayList<String> clientes;
    String busca;
    ListView listView;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        Intent intent = getIntent();
        atividade = this;
        busca = intent.getStringExtra(MainActivity.CHAVE);
        clientes = buscaClientes(busca);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clientes);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(atividade, DetalhesClienteActivity.class);
                intent.putExtra(NOME, clientes.get(position));
                startActivity(intent);
            }
        });
    }

    public ArrayList<String> buscaClientes(String chave) {
        ArrayList<String> lista = geraListaClientes();
        if (chave == null || chave.length() == 0) {
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for (String nome : lista) {
                if (nome.toUpperCase().contains(chave.toUpperCase())) {
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraListaClientes() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Carlos Drummond de Andrade");
        lista.add("Manuel Bandeira");
        lista.add("Olavo Bilac");
        lista.add("Vinícius de Moraes");
        lista.add("Cecília Meireles");
        lista.add("Castro Alves");
        lista.add("Gonçalves Dias");
        lista.add("Ferreira Gullar");
        lista.add("Machado de Assis");
        lista.add("Mário de Andrade");
        lista.add("Cora Coralina");
        lista.add("Manoel de Barros");
        lista.add("João Cabral de Melo Neto");
        lista.add("Casimiro de Abreu");
        lista.add("Paulo Leminski");
        lista.add("Álvares de Azevedo");
        lista.add("Guilherme de Almeida");
        lista.add("Alphonsus de Guimarães");
        lista.add("Mário Quintana");
        lista.add("Gregório de Matos");
        lista.add("Augusto dos Anjos");
        return lista;
    }
}
