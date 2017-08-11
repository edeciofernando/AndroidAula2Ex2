package br.com.edecio.duasactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtIdade = (TextView) findViewById(R.id.txtIdade);

        // para obter os parâmetros passados
        Intent it = getIntent();

        String nome = it.getStringExtra("nome");
        // -1, valor default (caso não for passado)
        int idade = it.getIntExtra("idade", -1);

        txtNome.setText("Olá " + nome);
        txtIdade.setText("Você possui " + idade + " anos");
    }

    public void VoltarActivity(View view) {
        Intent it = new Intent();

        // parâmetro a ser retornado para a activity main
        it.putExtra("cidade", "Pelotas");
        setResult(RESULT_OK, it);

        finish();
    }
}
