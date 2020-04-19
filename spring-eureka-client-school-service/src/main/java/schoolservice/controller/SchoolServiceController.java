package schoolservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SchoolServiceController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/getSchoolDetails/{schoolName}")
    public String getStudents(@PathVariable String schoolName) {
        System.out.println("Getting School details for " + schoolName);
        String response = restTemplate.exchange("http://student-service/getStudentDetailsForSchool/{schoolName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, schoolName).getBody();

        System.out.println("Response Received as " + response);

        return "School Name -  " + schoolName + " \n Student Details " + response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
