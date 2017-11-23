package com.usjt.arqdsis.clientesi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    public static final String CHAVE = "com.usjt.arqdsis.clientesi.busca";
    EditText txtBusca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBusca = findViewById(R.id.txt_busca);
    }

    public void buscarClientes(View view) {
        String busca = txtBusca.getText().toString();
        Intent intent = new Intent(this, ListaClientesActivity.class);
        intent.putExtra(CHAVE, busca);
        startActivity(intent);
    }
}
