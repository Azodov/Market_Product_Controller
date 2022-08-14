package com.fido.biznes.config;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public String formatDecimal(String number) {
        Locale locale = new Locale("uz", "UZ");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(Integer.parseInt(number));
    }
}
