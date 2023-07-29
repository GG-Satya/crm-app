package com.satya.crm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.crm.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
