package br.com.currencyconverter.converter.infra.http.clients.dto;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@ToString
public class IpInformation {
    private String ip;
}
