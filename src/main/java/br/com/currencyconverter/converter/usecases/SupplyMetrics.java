package br.com.currencyconverter.converter.usecases;

import br.com.currencyconverter.converter.events.ConversionSavedEvent;
import br.com.currencyconverter.converter.infra.metrics.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class SupplyMetrics {

    private final Metrics metrics;

    @TransactionalEventListener
    public void onConversionSaved(ConversionSavedEvent event) {
        metrics.save(event.getConversion());
    }
}
