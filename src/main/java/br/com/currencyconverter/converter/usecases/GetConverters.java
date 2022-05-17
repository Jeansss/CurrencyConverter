package br.com.currencyconverter.converter.usecases;


import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.infra.http.ConverterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetConverters {

  private final ConverterRepository converterRepository;

  public List<Converter> execute() {
    return converterRepository.findByCurrencyDestination("USD");
  }

}
