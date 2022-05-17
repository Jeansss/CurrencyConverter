package br.com.currencyconverter.converter.controllers;

import br.com.currencyconverter.converter.entities.Converter;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepService", url = "https://economia.awesomeapi.com.br/last")
public interface ConverterClient {

  @GetMapping("/{currencies}")
  public Map<String, Map<String, String>> getCurrencyQuote(@PathVariable String currencies);

}
