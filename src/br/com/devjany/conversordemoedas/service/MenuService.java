package br.com.devjany.conversordemoedas.service;

import br.com.devjany.conversordemoedas.api.dto.CurrencyConversion;
import br.com.devjany.conversordemoedas.exception.CurrencyConversionException;

import java.util.Scanner;

public class MenuService {
    private final CurrencyConverterService converterService;
    private final Scanner scanner;

    public MenuService(CurrencyConverterService converterService) {
        this.converterService = converterService;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("****************************************************");
        System.out.println("Seja bem-vindo/a ao Conversor de Moedas!");
        System.out.println("\n1) Dólar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dólar");
        System.out.println("3) Dólar ==>> Real Brasileiro");
        System.out.println("4) Real Brasileiro ==>> Dólar");
        System.out.println("5) Dólar ==>> Peso Colombiano");
        System.out.println("6) Peso Colombiano ==>> Dólar");
        System.out.println("7) Sair");
        System.out.println("Escolha uma opção válida: ");
        System.out.println("****************************************************");
    }

    public void processaOpcao(int opcao) {
        try {
            switch (opcao) {
                case 1 -> converterMoeda("USD", "ARS", "Dólar", "Peso argentino");
                case 2 -> converterMoeda("ARS", "USD", "Peso argentino", "Dólar");
                case 3 -> converterMoeda("USD", "BRL", "Dólar", "Real brasileiro");
                case 4 -> converterMoeda("BRL", "USD", "Real brasileiro", "Dólar");
                case 5 -> converterMoeda("USD", "COP", "Dólar", "Peso colombiano");
                case 6 -> converterMoeda("COP", "USD", "Peso colombiano", "Dólar");
                case 7 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } catch (CurrencyConversionException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void converterMoeda(String fromCode, String toCode, String fromName, String toName)
            throws CurrencyConversionException {
        System.out.printf("Digite o valor em %s: ", fromName);
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        CurrencyConversion conversion = converterService.convert(fromCode, toCode, amount);

        System.out.printf("%n%.2f %s (%s) = %.2f %s (%s)%nTaxa de câmbio: 1 %s = %.6f %s%n%n",
                conversion.amount(),
                fromName,
                fromCode,
                conversion.convertedAmount(),
                toName,
                toCode,
                fromCode,
                conversion.rate(),
                toCode);
    }
}
