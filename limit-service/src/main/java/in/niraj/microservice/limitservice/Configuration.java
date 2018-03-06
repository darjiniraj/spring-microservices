package in.niraj.microservice.limitservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by ndarji on 2/3/18.
 */

@Component
@ConfigurationProperties("limits-service")
@Data
public class Configuration {

    @Getter @Setter private int minimum;
    @Getter @Setter private  int maximum;


}
