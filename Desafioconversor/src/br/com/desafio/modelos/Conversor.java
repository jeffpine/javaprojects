package br.com.desafio.modelos;

import com.google.gson.JsonObject;

public class Conversor {
    private JsonObject  taxaDeCambio;

    public Conversor(JsonObject taxaDeCambio) {
        this.taxaDeCambio = taxaDeCambio;
    }
    public String converterMoeda(String moedaOrigem, String moedaDestino, double quantia) {
        moedaOrigem = moedaOrigem.toUpperCase();
        moedaDestino = moedaDestino.toUpperCase();

        if (taxaDeCambio.has(moedaOrigem) && taxaDeCambio.has(moedaDestino)) {
            double taxaOrigemADestino = taxaDeCambio.get(moedaDestino).getAsDouble();
            double taxaDestinoAOrigem = taxaDeCambio.get(moedaOrigem).getAsDouble();
            double quantiaConvertida = (quantia * taxaOrigemADestino) / taxaDestinoAOrigem;
            return String.format("%.2f", quantiaConvertida);
        } else {
            return "Moeda não encontrada em nossa base de dados.";
        }
    }
}
