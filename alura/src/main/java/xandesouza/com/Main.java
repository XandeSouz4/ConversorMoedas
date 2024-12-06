package xandesouza.com;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        ConsultaCot cotando = new ConsultaCot();
        Cotacao cotacao = cotando.buscaCot("USD");
        String[] moedasExibir = {"USD", "EUR", "GBP", "JPY", "CAD", "BRL"};
        System.out.println("Moeda buscada: " + cotacao.pegaBaseCode());
        System.out.println("Taxas de conversão: ");
        DecimalFormat df = new DecimalFormat("#0.00");
        for (String moeda : moedasExibir) {
            Float valor = cotacao.pegaConversionRates().get(moeda);
            if (valor != null) {
                System.out.println(moeda + ": " + df.format(valor));
            }else {
                System.out.println(moeda + ": Não encontrada");
            }

        }

    }
}