package br.com.devjany.conversordemoedas;

import br.com.devjany.conversordemoedas.api.ExchangeRateApiClient;
import br.com.devjany.conversordemoedas.service.CurrencyConverterService;
import br.com.devjany.conversordemoedas.service.MenuService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeRateApiClient apiClient = new ExchangeRateApiClient();
        CurrencyConverterService converterService = new CurrencyConverterService(apiClient);
        MenuService menuService = new MenuService(converterService);
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            menuService.exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            menuService.processaOpcao(opcao);
        } while (opcao != 7);

        scanner.close();

    }
}
