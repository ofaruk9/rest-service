package com.example.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.restservice.utils.PointUtils.calculatePointsAndPrint;

@RestController
public class ServiceController {

    @PostMapping("/process")
    public Customer calculatePoints(@RequestBody Customer customerList) {
        return calculatePointsAndPrint(customerList);

    }

}
