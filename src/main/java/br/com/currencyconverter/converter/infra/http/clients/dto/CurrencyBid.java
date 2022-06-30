package br.com.currencyconverter.converter.infra.http.clients.dto;

import br.com.currencyconverter.converter.infra.http.controllers.dto.CurrencyConversion;

import java.math.BigDecimal;
import java.util.HashMap;

public class CurrencyBid extends HashMap<String, CurrencyConversion> {

    public BigDecimal getBidByKey(String key) {
        return this.get(key).getBid();
    }

}
