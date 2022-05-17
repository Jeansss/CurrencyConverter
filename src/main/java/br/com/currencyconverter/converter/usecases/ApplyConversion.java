package br.com.currencyconverter.converter.usecases;

import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.events.ConversionAppliedEvent;
import br.com.currencyconverter.converter.infra.http.ConverterRepository;
import br.com.currencyconverter.converter.infra.http.model.CurrencyInformation;
import br.com.currencyconverter.converter.infra.repositories.ConverterClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplyConversion {

  private final ConverterClient converterClient;
  private final ApplicationEventPublisher publisher;

  public CurrencyInformation execute(Converter converter) {
    CurrencyInformation currencyInformation = converterClient.getCurrencyQuote(converter.getConversionKey());
    publisher.publishEvent(new ConversionAppliedEvent(converter, currencyInformation));
    return currencyInformation;
  }
}
