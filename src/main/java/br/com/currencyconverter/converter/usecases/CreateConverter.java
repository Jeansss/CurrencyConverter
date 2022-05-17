package br.com.currencyconverter.converter.usecases;

import br.com.currencyconverter.converter.controllers.ConverterClient;
import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.repositories.ConverterRepository;
import java.math.BigDecimal;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateConverter {

  private final ConverterRepository converterRepository;
  private final ConverterClient converterClient;

  public Converter execute(Converter converter) {
    Map<String, Map<String, String>> currencyInformation = converterClient.getCurrencyQuote(converter.getOriginOfCurrency() + "-" + converter.getCurrencyDestination());
    converter.setConvertedValue(new BigDecimal(currencyInformation.get(converter.getOriginOfCurrency() + converter.getCurrencyDestination()).get("bid")));


    return converterRepository.create(converter);
  }
}
