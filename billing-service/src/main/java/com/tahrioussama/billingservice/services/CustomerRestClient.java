package com.tahrioussama.billingservice.services;

import com.tahrioussama.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path="/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
}