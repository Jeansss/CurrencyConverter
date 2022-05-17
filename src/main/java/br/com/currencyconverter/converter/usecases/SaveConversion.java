package br.com.currencyconverter.converter.usecases;

import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.events.ConversionAppliedEvent;
import br.com.currencyconverter.converter.infra.http.ConverterRepository;
import br.com.currencyconverter.converter.infra.http.model.CurrencyInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveConversion {

    private final ConverterRepository converterRepository;

    @EventListener
    public void onApplicationEvent(ConversionAppliedEvent event) {
        CurrencyInformation currencyInformation = event.getCurrencyInformation();

        Converter converter = event.getConverter();
        converter.setConvertedValue(currencyInformation.getBid());

        converterRepository.save(converter);
    }

}
