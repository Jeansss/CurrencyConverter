package br.com.currencyconverter.converter.entities;


import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "conversions")
public class Converter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String ip;

  @Column(name = "value")
  private BigDecimal valueNotConverted;
  @Column(name = "origin_currency")
  private String originOfCurrency;
  @Column(name = "currency_destination")
  private String currencyDestination;
  @Column(name = "converted_value")
  private BigDecimal convertedValue;

  public void setConvertedValue(BigDecimal currencyQuote) {
    this.convertedValue = this.valueNotConverted.multiply(currencyQuote).setScale(2 ,RoundingMode.HALF_UP);
  }
}
