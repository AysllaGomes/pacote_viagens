package ayslla.gomes.viagens.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import ayslla.gomes.viagens.R;
import ayslla.gomes.viagens.model.Pacote;

import static ayslla.gomes.viagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

import androidx.appcompat.app.AppCompatActivity;

public class InformacoesPessoaisActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Informações Pessoais";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

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
        Button button = findViewById(R.id.pagamento_botao_finaliza_compra);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiParaResumo(pacote);
            }
        });
    }

    private void vaiParaResumo(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

}
