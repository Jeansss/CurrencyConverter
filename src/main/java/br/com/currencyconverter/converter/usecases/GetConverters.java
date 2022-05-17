package br.com.currencyconverter.converter.usecases;


import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.repositories.ConverterRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetConverters {

  private final ConverterRepository converterRepository;

  public List<Converter> execute() {
    return converterRepository.findByCurrencyDestination("USD");
  }

}
