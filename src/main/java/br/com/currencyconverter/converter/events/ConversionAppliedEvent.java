package br.com.currencyconverter.converter.events;

import br.com.currencyconverter.converter.entities.Conversion;
import br.com.currencyconverter.converter.infra.http.controllers.dto.CurrencyInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class ConversionAppliedEvent {
    private final Conversion conversion;
}
