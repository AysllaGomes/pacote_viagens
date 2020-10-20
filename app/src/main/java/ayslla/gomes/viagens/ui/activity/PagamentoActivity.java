package ayslla.gomes.viagens.ui.activity;

import java.math.BigDecimal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import ayslla.gomes.viagens.R;
import ayslla.gomes.viagens.model.Pacote;
import ayslla.gomes.viagens.util.MoedaUtil;

import androidx.appcompat.app.AppCompatActivity;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITLE_APPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraPreco(pacote);

        Button buttonRealizaPagamento = findViewById(R.id.pagamento_botao_finaliza_compra);
        buttonRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

}
