import br.com.desafio.modelos.ConexaoApi;
import br.com.desafio.modelos.Conversor;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try {
            boolean continuar = true;

            while (continuar) {
                System.out.println("Digite a moeda que deseja converter: ");
                String moedaBase = scanner.nextLine();
                moedaBase = moedaBase.toUpperCase();

                JsonObject taxasObjeto = ConexaoApi.getExchangeRates(moedaBase); //chamando o metodo para obter as taxas de cambio
                JsonObject taxasDeConversao = taxasObjeto.getAsJsonObject("conversion_rates"); //extrai o objeto conversion rates


                //impressão das moedas disponiveis.
                System.out.println("Moedas disponiveis:");
                Set<String> moedas = taxasDeConversao.keySet();
                int count = 0;
                for (String moeda : moedas) {
                    System.out.printf("%-10s", moeda);
                    count++;
                    if (count % 10 == 0) {
                        System.out.println();
                    }
                }
                System.out.println("\n");

                System.out.println("Digite para qual moeda deseja converter: ");
                String segundaMoeda = scanner.nextLine();
                segundaMoeda = segundaMoeda.toUpperCase();
                System.out.println("Digite a quantia de " + moedaBase + " que deseja converter para " + segundaMoeda+ ":");
                double amountToConvert = scanner.nextDouble();
                scanner.nextLine();

                Conversor conversor = new Conversor(taxasDeConversao); // criaçao de instancia conversora

                String moedaConvertida = conversor.converterMoeda(moedaBase, segundaMoeda, amountToConvert);
                System.out.println(moedaBase + " a " + segundaMoeda + " = " + moedaConvertida);


                System.out.println("Deseja realizar outra conversao? (s/n)");
                String resposta = scanner.nextLine();
                if (!resposta.equals("s")) {
                    continuar = false;
                }
            }
        } catch (IOException e){
            System.err.println("Erro ao obter as taxas de cambio: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
