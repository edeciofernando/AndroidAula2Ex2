package br.com.edecio.duasactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PularProxima(View view) {
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIdade = (EditText) findViewById(R.id.edtIdade);

        String nome = edtNome.getText().toString();
        int idade = Integer.parseInt(edtIdade.getText().toString());

        Intent it = new Intent(this, SegundaActivity.class);
        // para passar dados para a segunda activity
        it.putExtra("nome", nome);
        it.putExtra("idade", idade);

        // carrega a segunda activity
        // startActivity(it);
        startActivityForResult(it, 20);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == RESULT_OK) {
            // obtém a string de retorno
            String retorno = data.getStringExtra("cidade");
            Toast.makeText(this, "Você mora em "+retorno, Toast.LENGTH_LONG).show();
        }
    }
}
