package com.netCracker3.controller.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Main interface of specification for findCustomer command
 * @see CustomerSpecification for view search rules
 * @param <Customer>
 */
public interface Specification<Customer> {
    Predicate toPredicate(Root<Customer> root, CriteriaQuery<Customer> query,
                          CriteriaBuilder builder);
}
