package br.com.currencyconverter.converter.events;

import br.com.currencyconverter.converter.entities.Conversion;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ConversionSavedEvent{
    private final Conversion conversion;
}
