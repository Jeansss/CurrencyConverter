package br.com.currencyconverter.converter.usecases;

import br.com.currencyconverter.converter.entities.Conversion;
import br.com.currencyconverter.converter.events.ConversionAppliedEvent;
import br.com.currencyconverter.converter.infra.http.clients.IpClient;
import br.com.currencyconverter.converter.infra.http.clients.dto.CurrencyBid;
import br.com.currencyconverter.converter.infra.http.clients.ConverterClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplyConversion {

  private final IpClient ipService;
  private final ConverterClient converterClient;
  private final ApplicationEventPublisher publisher;
  public Conversion execute(Conversion conversion) {
    CurrencyBid currencyBid = converterClient.getCurrencyQuote(conversion.getConversionParam());

    conversion.setIp(ipService.getIp());
    conversion.setConvertedValue(currencyBid.getBidByKey(conversion.getConversionKey()));

    publisher.publishEvent(new ConversionAppliedEvent(conversion));
    return conversion;
  }
}
