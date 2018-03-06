package in.niraj.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by ndarji on 2/3/18.
 */
@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue currencyExchanger(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue= exchangeValueRepository.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
