package demoapi;

import demoapi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceRestTemplate {
    RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMyPetWithStatusAs(String status){
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("/v2/pet/findByStatus?status="+status,Object.class);
        return String.valueOf(responseEntity.getBody());
    }
}
