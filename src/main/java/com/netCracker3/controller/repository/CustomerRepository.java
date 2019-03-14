package com.netCracker3.controller.repository;

import com.netCracker3.model.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This interface is repository of customer's DB
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAll();
    @Override
    Optional<Customer> findById(Integer integer);
    @Override
    List<Customer> findAll(Specification<Customer> spec);
}
