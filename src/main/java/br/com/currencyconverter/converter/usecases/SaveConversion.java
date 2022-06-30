package br.com.currencyconverter.converter.usecases;

import br.com.currencyconverter.converter.entities.Conversion;
import br.com.currencyconverter.converter.events.ConversionAppliedEvent;
import br.com.currencyconverter.converter.events.ConversionSavedEvent;
import br.com.currencyconverter.converter.infra.db.ConverterRepository;
import br.com.currencyconverter.converter.infra.http.controllers.dto.CurrencyInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class SaveConversion {

    private final ConverterRepository converterRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    @EventListener
    public void onConversionAppliedEventPersistOnRepository(ConversionAppliedEvent event) {
        Conversion conversion = converterRepository.save(event.getConversion());
        publisher.publishEvent(new ConversionSavedEvent(conversion));
    }
}
