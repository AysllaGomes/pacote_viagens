package ayslla.gomes.viagens.util;

import java.util.Locale;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MoedaUtil {

    public static final String PT = "pt";
    public static final String BR = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_DESEJADO = "R$ ";

    public static String formataParaBrasileiro(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PT, BR));
        return formatoBrasileiro
                .format(valor)
                .replace(FORMATO_PADRAO, FORMATO_DESEJADO);
    }

}
