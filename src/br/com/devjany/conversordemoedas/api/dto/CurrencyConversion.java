package br.com.devjany.conversordemoedas.api.dto;

public record CurrencyConversion(
        String fromCurrency,
        String toCurrency,
        double amount,
        double convertedAmount,
        double rate
) {}
