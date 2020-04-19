package studentservice.util;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SpringEurekaClientStudentServiceInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("details",
                Collections.singletonMap("description", "This is the Student service, which is discovery server aware, and this service will be Called by school Microservice, fro student details, which is again discovery server aware!!! "));
    }
}