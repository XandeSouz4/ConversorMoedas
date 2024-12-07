package xandesouza.com;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal {
    private final Map<String, String> cotacaoMoeda;
    private final Scanner leitura;

    public MenuPrincipal() {
        cotacaoMoeda = new HashMap<>();
        cotacaoMoeda.put("1", "BRL");
        cotacaoMoeda.put("2", "USD");
        cotacaoMoeda.put("3", "EUR");
        cotacaoMoeda.put("4", "GBP");
        cotacaoMoeda.put("5", "JPY");
        cotacaoMoeda.put("6", "CHF");

        leitura = new Scanner(System.in);
    }
    public void mostrarCotacao() {
        System.out.println("\n---- Cotações disponiveis! ----");
        for(Map.Entry<String, String> entry : cotacaoMoeda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("0 - Sair");
    }
    public void iniciar() {

        while (true) { 
            mostrarCotacao();
            System.out.print("\nEscolha a moeda que deseja cotar ou (ou 0 para sair): ");
            String escolha = leitura.nextLine();
            if (escolha.equals("0")) {
                System.out.println("Obrigado por utilizar!");
                break;
            }
            if (cotacaoMoeda.containsKey(escolha)) {
                String moedaSelecionada = cotacaoMoeda.get(escolha);
                System.out.println("\nVocê selecionou : " + moedaSelecionada);
                ConsultaCot cotando = new ConsultaCot();
                Cotacao cotacao = cotando.buscaCot(moedaSelecionada);
                String[] moedasExibir = {"USD", "EUR", "GBP", "JPY", "CAD", "BRL"};
                List<String> moedasParaExibir = new ArrayList<>(Arrays.asList(moedasExibir));
                moedasParaExibir.remove(cotacao.pegaBaseCode());
                System.out.println("Moeda buscada: " + cotacao.pegaBaseCode());
                System.out.println("Taxas de conversão: ");
                DecimalFormat df = new DecimalFormat("#0.00");
                for (String moeda : moedasParaExibir) {
                    Float valor = cotacao.pegaConversionRates().get(moeda);
                    if (valor != null) {
                        System.out.println(moeda + ": " + df.format(valor));
                    }else {
                        System.out.println(moeda + ": Não encontrada");
                    }
            }}else {
                        System.out.println("Opção inválida. Por favor tente novamente!");
                    }
                   } 
        }
    }
