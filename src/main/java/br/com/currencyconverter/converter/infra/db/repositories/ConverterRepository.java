package br.com.currencyconverter.converter.infra.db.repositories;

import br.com.currencyconverter.converter.entities.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConverterRepository extends JpaRepository<Conversion, Integer> {

  List<Conversion> findByCurrencyDestination(String currencyDestination);


}
