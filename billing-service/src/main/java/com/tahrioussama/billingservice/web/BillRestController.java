package com.tahrioussama.billingservice.web;

import com.tahrioussama.billingservice.entities.Bill;
import com.tahrioussama.billingservice.repositories.BillRepository;
import com.tahrioussama.billingservice.repositories.ProductItemRepository;
import com.tahrioussama.billingservice.services.CustomerRestClient;
import com.tahrioussama.billingservice.services.ProductRestClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BillRestController {

    private BillRepository billRepository;

    private ProductItemRepository productItemRepository;

    private CustomerRestClient customerRestClient;

    private ProductRestClient productRestClient;

    @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
        });
        return bill;
    }
}