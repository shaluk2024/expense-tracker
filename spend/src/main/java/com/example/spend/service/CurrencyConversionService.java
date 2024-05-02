package com.example.spend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CurrencyConversionService {
    private static final String EXCHANGE_RATE_API_URL = "https://api.exchangerate-api.com/v4/latest/USD"; 

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public Map<String, Double> fetchExchangeRatesFromApi(){
        Map<String, Object> exchangeRates = restTemplateBuilder.build().getForObject(EXCHANGE_RATE_API_URL, Map.class);

        Map<String, Double> rates = (Map<String, Double>) exchangeRates.get("rates");

        return rates;
    }

    public Double getExchangeRate(String targetCurrency, Map<String, Double> rates ) {

        return rates != null ? rates.get(targetCurrency) : 0;
    }

    public BigDecimal convertCurrency(BigDecimal amount, String fromCurrency, String toCurrency, Map<String, Double> rates) {
        Double exchangeRate = getExchangeRate(toCurrency, rates);

        return amount.multiply(new BigDecimal(exchangeRate));
    }

    public BigDecimal convertCurrencyToUSD(BigDecimal amount, String fromCurrency, String toCurrency, Map<String, Double> rates) {
        Double exchangeRate = getExchangeRate(fromCurrency, rates);

        return amount.divide(new BigDecimal(exchangeRate),  2, RoundingMode.HALF_UP);
    }

}

