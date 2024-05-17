package br.com.desafio.modelos;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConexaoApi {
    private static final String API_CHAVE = "348d7fd2f95cf604e28ee8d3"; //CHAVE DA API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static JsonObject getExchangeRates(String moedaBase) throws IOException {
        String apiUrl = API_URL + API_CHAVE + "/latest/" + moedaBase;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");


        if (conn.getResponseCode() == 200) {
                    //response body
        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder responseBody = new StringBuilder();
        while (scanner.hasNextLine()) {
            responseBody.append(scanner.nextLine());
        }
        scanner.close();
        conn.disconnect();


            JsonParser parser = new JsonParser();
            return parser.parse(responseBody.toString()).getAsJsonObject();
        } else {
            throw new IOException("Falha ao buscar taxas de câmbio. Código de resposta: " + conn.getResponseCode());
        }
    }
}
