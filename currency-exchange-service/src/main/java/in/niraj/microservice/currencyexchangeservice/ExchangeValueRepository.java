package in.niraj.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ndarji on 2/3/18.
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String find, String to);



}
