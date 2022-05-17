package br.com.currencyconverter.converter.controllers;

import br.com.currencyconverter.converter.entities.Converter;
import br.com.currencyconverter.converter.usecases.CreateConverter;
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

  private final CreateConverter createConverter;
  private final GetConverters getConverters;

  @PostMapping
  public ResponseEntity<Converter> create(@RequestBody Converter converter) {
    return ResponseEntity.ok(this.createConverter.execute(converter));
  }

  @GetMapping
  public List<Converter> listConverter() {
    return getConverters.execute();
  }

}
