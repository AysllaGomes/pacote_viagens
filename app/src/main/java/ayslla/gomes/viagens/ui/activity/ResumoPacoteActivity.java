package ayslla.gomes.viagens.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import ayslla.gomes.viagens.R;
import ayslla.gomes.viagens.model.Pacote;
import ayslla.gomes.viagens.util.DataUtil;
import ayslla.gomes.viagens.util.DiasUtil;
import ayslla.gomes.viagens.util.MoedaUtil;
import ayslla.gomes.viagens.util.ResourceUtil;

import static ayslla.gomes.viagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITLE_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacote);
            configuraBotao(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void configuraBotao(Pacote pacote) {
        Button button = findViewById(R.id.resumo_pacote_button_informa_dados_pessoais);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiParaInformacoesPessoais(pacote);
            }
        });
    }

    private void vaiParaInformacoesPessoais(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, InformacaoDadosPessoaisActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

}
