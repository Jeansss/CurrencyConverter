package br.com.currencyconverter.converter.infra.metrics;

import org.springframework.stereotype.Component;

@Component
public class Metrics {
    public void save(Object object) {
        System.out.println("The object was saved " + object);
    };
}