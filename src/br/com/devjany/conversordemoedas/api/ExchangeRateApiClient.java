package br.com.devjany.conversordemoedas.api;

import br.com.devjany.conversordemoedas.api.dto.ExchangeRateResponse;
import br.com.devjany.conversordemoedas.exception.ApiConnectionException;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiClient {
    private static final String API_KEY = "eff88959906fa454bf42ad13"; // Substitua pela sua chave
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private final HttpClient client;
    private final Gson gson;

    public ExchangeRateApiClient() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ExchangeRateResponse getExchangeRates(String baseCurrency) throws ApiConnectionException {
        try {
            String url = BASE_URL + baseCurrency;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 401) {
                throw new ApiConnectionException("API Key inválida ou não fornecida");
            }

            if (response.statusCode() != 200) {
                throw new ApiConnectionException("Erro ao acessar a API: " + response.statusCode());
            }

            return gson.fromJson(response.body(), ExchangeRateResponse.class);
        } catch (Exception e) {
            throw new ApiConnectionException("Falha na conexão com a API: " + e.getMessage(), e);
        }
    }
}