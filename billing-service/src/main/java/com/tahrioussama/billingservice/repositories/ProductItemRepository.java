package com.tahrioussama.billingservice.repositories;

import com.tahrioussama.billingservice.entities.Bill;
import com.tahrioussama.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
