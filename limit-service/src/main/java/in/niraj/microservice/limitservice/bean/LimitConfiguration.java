package in.niraj.microservice.limitservice.bean;
import lombok.Data;
/**
 * Created by ndarji on 2/3/18.
 */

@Data
public class LimitConfiguration {

private int maximum;
private int minimum;

    public LimitConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }
}
