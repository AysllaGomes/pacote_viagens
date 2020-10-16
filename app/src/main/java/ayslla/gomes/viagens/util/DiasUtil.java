package ayslla.gomes.viagens.util;

import androidx.annotation.NonNull;

public class DiasUtil {

    @NonNull
    public static String formataEmTexto(int quantidadeDias) {
        if (quantidadeDias > 1) {
            return quantidadeDias + " dias";
        }

        return quantidadeDias + " dia";
    }

}
