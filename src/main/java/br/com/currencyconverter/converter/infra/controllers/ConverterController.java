package br.com.currencyconverter.converter.infra.controllers;

import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.infra.http.model.CurrencyInformation;
import br.com.currencyconverter.converter.usecases.ApplyConversion;
import br.com.currencyconverter.converter.usecases.GetConverters;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/converter")
public class ConverterController {

  private final ApplyConversion applyConversion;
  private final GetConverters getConverters;

  @PostMapping
  public ResponseEntity<CurrencyInformation> create(@RequestBody Converter converter) {
    return ResponseEntity.ok(this.applyConversion.execute(converter));
  }

  @GetMapping
  public List<Converter> listConverter() {
    return getConverters.execute();
  }

}
