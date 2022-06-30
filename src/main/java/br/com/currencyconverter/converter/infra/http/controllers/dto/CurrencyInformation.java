package br.com.currencyconverter.converter.infra.http.controllers.dto;

import br.com.currencyconverter.converter.infra.http.clients.dto.CurrencyBid;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
public class CurrencyInformation {

    private CurrencyBid currencyBid;

    public BigDecimal getBid(String key) {
        return currencyBid.getBidByKey(key);
    }
}
