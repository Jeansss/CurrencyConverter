package br.com.currencyconverter.converter.infra.repositories;

import br.com.currencyconverter.converter.infra.http.model.CurrencyInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepService", url = "https://economia.awesomeapi.com.br/last")
public interface ConverterClient {

  @GetMapping("/{currencies}")
  CurrencyInformation getCurrencyQuote(@PathVariable String currencies);

}
