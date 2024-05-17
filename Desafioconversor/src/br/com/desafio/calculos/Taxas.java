package br.com.desafio.calculos;

import java.util.Map;

public class Taxas {
    private Map<String, Double> exchangeRates;

    public Taxas(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public double converteMoeda(double amount, String fromCurrency, String toCurrency ) {
        double fromRate = exchangeRates.getOrDefault(fromCurrency,1.0);
        double toRate = exchangeRates.getOrDefault(toCurrency,1.0);
        //calculo de conversão
        return amount * (toRate / fromRate);
    }
}
