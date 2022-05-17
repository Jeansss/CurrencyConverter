package br.com.currencyconverter.converter.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConverterDto {

  private final String ip;
  private final BigDecimal value;
  private final String originOfCurrency;
  private final String currencyDestination;

}
