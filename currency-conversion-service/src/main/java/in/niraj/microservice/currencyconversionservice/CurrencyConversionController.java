package in.niraj.microservice.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ndarji on 2/3/18.
 */
@RestController
public class CurrencyConversionController {

    @Autowired
    private  CurrencyExchangeServiceProxy exchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        Map uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class, uriVariables);

        CurrencyConversionBean conversionBean = response.getBody();
        return  new CurrencyConversionBean(conversionBean.getId(), from,to, conversionBean.getConversionMultiple(),quantity, quantity.multiply(conversionBean.getConversionMultiple()),conversionBean.getPort());
    }


    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyUsingFeignClient(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionBean conversionBean = exchangeServiceProxy.currencyExchanger(from,to);
        return  new CurrencyConversionBean(conversionBean.getId(), from,to, conversionBean.getConversionMultiple(),quantity, quantity.multiply(conversionBean.getConversionMultiple()),conversionBean.getPort());
    }
}
