package br.com.currencyconverter.converter.entities;


import br.com.currencyconverter.converter.controllers.ConverterClient;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Converter {

  private int id;
  private final String ip;
  private final BigDecimal valueNotConverted;
  private final String originOfCurrency;
  private final String currencyDestination;
  private BigDecimal convertedValue;

  public void setId(int id) {
    this.id = id;
  }

  public void setConvertedValue(BigDecimal currencyQuote) {
    this.convertedValue = this.valueNotConverted.multiply(currencyQuote).setScale(2 ,RoundingMode.HALF_UP);
  }
}
