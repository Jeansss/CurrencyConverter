package br.com.currencyconverter.converter.repositories;

import br.com.currencyconverter.converter.entities.Converter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConverterRepository extends JpaRepository<Converter, Integer> {

  public List<Converter> findByCurrencyDestination(String currencyDestination);

//  private final List<Converter> db = new ArrayList<>();
//  private int id = 0;

//  public Converter create(Converter converter) {
//    converter.setId(++id);
//    db.add(converter);
//    return converter;
//  }
//
//  public List<Converter> findAll() {
//    return db;
//  }


}
