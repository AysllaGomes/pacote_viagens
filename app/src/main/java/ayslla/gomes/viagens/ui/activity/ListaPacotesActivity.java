package ayslla.gomes.viagens.ui.activity;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ListView;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import ayslla.gomes.viagens.R;
import ayslla.gomes.viagens.dao.PacoteDAO;
import ayslla.gomes.viagens.model.Pacote;
import ayslla.gomes.viagens.ui.adapter.ListaPacotesAdapter;

import static ayslla.gomes.viagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listView);
        final List<Pacote> pacoteList = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacoteList, this));

        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Pacote itemPacote = pacoteList.get(position);
                vaiParaResumoPacote(itemPacote);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote itemPacote) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, itemPacote);
        startActivity(intent);
    }

}
