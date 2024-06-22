package br.com.jeffpine.literalura.service;

import br.com.jeffpine.literalura.model.Livro;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GutendexService {

    @Autowired
    private LivroService livroService;

    public void buscarELivroPorTituloESalvar(String titulo) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String encodedTitulo = URLEncoder.encode(titulo, StandardCharsets.UTF_8.toString());
        HttpGet request = new HttpGet("https://gutendex.com/books/?search=" + encodedTitulo);
        String response = EntityUtils.toString(client.execute(request).getEntity());

        JSONObject jsonResponse = new JSONObject(response);
        JSONArray results = jsonResponse.getJSONArray("results");

        if (results.length() > 0) {
            JSONObject livroJson = results.getJSONObject(0);

            Livro livro = new Livro();
            livro.setTitulo(livroJson.getString("title"));
            livro.setAutor(livroJson.getJSONArray("authors").getJSONObject(0).getString("name"));
            livro.setIdioma(livroJson.getJSONArray("languages").getString(0));
            livro.setNumeroDownloads(livroJson.getInt("download_count"));

            livroService.salvar(livro);
        }
    }
}