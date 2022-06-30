package br.com.currencyconverter.converter.infra.http.clients;

import br.com.currencyconverter.converter.infra.http.clients.dto.IpInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ipClient", url = "https://api.ipify.org")
public interface IpClient {

    @GetMapping
    String getIp();
}
