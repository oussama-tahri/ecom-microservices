package com.tahrioussama.billingservice.repositories;

import com.tahrioussama.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
