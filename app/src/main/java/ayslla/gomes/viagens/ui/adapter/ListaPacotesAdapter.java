package ayslla.gomes.viagens.ui.adapter;

import java.util.List;

import android.widget.TextView;
import android.widget.ImageView;
import android.widget.BaseAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import android.content.Context;

import android.graphics.drawable.Drawable;

import ayslla.gomes.viagens.R;
import ayslla.gomes.viagens.model.Pacote;
import ayslla.gomes.viagens.util.DiasUtil;
import ayslla.gomes.viagens.util.MoedaUtil;
import ayslla.gomes.viagens.util.ResourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() { return pacotes.size(); }

    @Override
    public Pacote getItem(int position) { return pacotes.get(position); }

    @Override
    public long getItemId(int i) { return 0; }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View createView = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(createView, pacote);
        mostraImagem(createView, pacote);
        mostraDias(createView, pacote);
        mostraPreco(createView, pacote);

        return createView;
    }

    private void mostraLocal(View createView, Pacote pacote) {
        TextView local = createView.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(View createView, Pacote pacote) {
        ImageView imagem = createView.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraDias(View createView, Pacote pacote) {
        TextView dias = createView.findViewById(R.id.item_pacote_dias);
        String diasText = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasText);
    }

    private void mostraPreco(View createView, Pacote pacote) {
        TextView preco = createView.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

}
