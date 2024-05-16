import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // chama a biblioteca Gson
        FileWriter escrita = new FileWriter(endereco.cep() + ".json"); //gera o arquivo json
        escrita.write(gson.toJson(endereco)); //escreve no arquivo
        escrita.close();
    }
}
