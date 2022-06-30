package br.com.currencyconverter.converter.infra.http.controllers;

import br.com.currencyconverter.converter.entities.Conversion;
import br.com.currencyconverter.converter.usecases.ApplyConversion;
import br.com.currencyconverter.converter.usecases.GetConverters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

class IpService {

  private final String LOCALHOST_IPV4 = "127.0.0.1";
  private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

  public String getClientIp(HttpServletRequest request) {
    String ipAddress = request.getHeader("X-Forwarded-For");
    if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader("Proxy-Client-IP");
    }

    if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getHeader("WL-Proxy-Client-IP");
    }

    if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
      if(LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
        try {
          InetAddress inetAddress = InetAddress.getLocalHost();
          ipAddress = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
          e.printStackTrace();
        }
      }
    }

    if(!StringUtils.isEmpty(ipAddress)
            && ipAddress.length() > 15
            && ipAddress.indexOf(",") > 0) {
      ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
    }

    return ipAddress;
  }
}

@RestController
@RequiredArgsConstructor
@RequestMapping("/converter")
public class ConverterController {

  private final ApplyConversion applyConversion;
  private final GetConverters getConverters;

  @PostMapping
  public Conversion create(@RequestBody Conversion conversion) throws UnknownHostException {
    return this.applyConversion.execute(conversion);
  }

  @GetMapping
  public List<Conversion> listConverter() {
    return getConverters.execute();
  }

}
