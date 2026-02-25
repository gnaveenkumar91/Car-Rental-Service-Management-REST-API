package com.vcube.crsapp01.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.crsapp01.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
