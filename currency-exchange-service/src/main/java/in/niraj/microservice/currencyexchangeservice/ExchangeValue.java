package in.niraj.microservice.currencyexchangeservice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ndarji on 2/3/18.
 */
@Data
@Entity
public class ExchangeValue {

    @Id
    private  Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private  String to;

    private BigDecimal conversionMultiple;
    private int port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
