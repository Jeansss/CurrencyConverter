package br.com.currencyconverter.converter.infra.http;

import br.com.currencyconverter.converter.entities.Converter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConverterRepository extends JpaRepository<Converter, Integer> {

  List<Converter> findByCurrencyDestination(String currencyDestination);


}
