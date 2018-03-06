package in.niraj.microservice.limitservice;

import in.niraj.microservice.limitservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ndarji on 2/3/18.
 */
@RestController
public class LimitConfigurationController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration getLimitConfiguration(){
        return  new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
