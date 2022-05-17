package br.com.currencyconverter.converter.events;

import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.infra.http.model.CurrencyInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;

@Getter
@RequiredArgsConstructor
public class ConversionAppliedEvent {
    private final Converter converter;
    private final CurrencyInformation currencyInformation;
}
