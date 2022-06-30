package br.com.currencyconverter.converter.usecases;


import br.com.currencyconverter.converter.entities.Conversion;
import br.com.currencyconverter.converter.infra.db.ConverterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetConverters {

  private final ConverterRepository converterRepository;

  public List<Conversion> execute() {
    return converterRepository.findByCurrencyDestination("USD");
  }

}
