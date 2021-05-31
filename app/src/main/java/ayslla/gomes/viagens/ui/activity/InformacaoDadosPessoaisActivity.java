package ayslla.gomes.viagens.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import ayslla.gomes.viagens.R;
import ayslla.gomes.viagens.model.Pacote;

import static ayslla.gomes.viagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class InformacaoDadosPessoaisActivity extends AppCompatActivity {


    public static final String TITLE_APPBAR = "Informação dos Dados Pessoais";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_dados_pessoais);

        setTitle(TITLE_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button button = findViewById(R.id.informacao_dados_pessoais_redireciona_pagamento);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { vaiParaPagamento(pacote); }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(InformacaoDadosPessoaisActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

}
