package br.com.currencyconverter.converter.infra.http.controllers.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class CurrencyConversion {
    private BigDecimal bid;
}
