package ie.atu.experiencelevel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "weight-service", url = "http://localhost:8080/api")
public interface WeightClassClient {
    @GetMapping("/weight-class/{id}")
    WeightClass getWeightClassById(@PathVariable("id") Long id);
}