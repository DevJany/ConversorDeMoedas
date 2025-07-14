package br.com.devjany.conversordemoedas.service;

import br.com.devjany.conversordemoedas.api.ExchangeRateApiClient;
import br.com.devjany.conversordemoedas.api.dto.CurrencyConversion;
import br.com.devjany.conversordemoedas.api.dto.ExchangeRateResponse;
import br.com.devjany.conversordemoedas.exception.CurrencyConversionException;

public class CurrencyConverterService {
    private final ExchangeRateApiClient apiClient;

    public CurrencyConverterService(ExchangeRateApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public CurrencyConversion convert(String fromCurrency, String toCurrency, double amount)
            throws CurrencyConversionException {
        try {
            // Sempre buscamos as taxas com base na moeda de origem
            ExchangeRateResponse response = apiClient.getExchangeRates(fromCurrency);

            if (!response.conversion_rates().containsKey(toCurrency)) {
                throw new CurrencyConversionException("Moeda de destino não encontrada: " + toCurrency);
            }

            double rate = response.conversion_rates().get(toCurrency);
            double convertedAmount = amount * rate;

            return new CurrencyConversion(fromCurrency, toCurrency, amount, convertedAmount, rate);
        } catch (Exception e) {
            throw new CurrencyConversionException("Erro na conversão de moedas: " + e.getMessage(), e);
        }
    }
}