package br.com.currencyconverter.converter.infra.http.clients;

import br.com.currencyconverter.converter.infra.http.clients.dto.CurrencyBid;
import br.com.currencyconverter.converter.infra.http.controllers.dto.CurrencyInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "converterClient", url = "https://economia.awesomeapi.com.br/last")
public interface ConverterClient {

  @GetMapping("/{currencies}")
  CurrencyBid getCurrencyQuote(@PathVariable String currencies);

}
