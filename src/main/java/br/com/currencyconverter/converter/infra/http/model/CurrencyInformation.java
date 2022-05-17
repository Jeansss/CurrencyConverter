package br.com.currencyconverter.converter.infra.http.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyInformation {
    private String bid;

    public BigDecimal getBid() {
        return new BigDecimal(bid);
    }
}
