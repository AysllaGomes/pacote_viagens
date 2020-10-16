package ayslla.gomes.viagens.ui.activity;

import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import ayslla.gomes.viagens.R;
import ayslla.gomes.viagens.dao.PacoteDAO;
import ayslla.gomes.viagens.model.Pacote;
import ayslla.gomes.viagens.ui.adapter.ListaPacotesAdapter;

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
        List<Pacote> pacoteList = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacoteList, this));
    }

}
