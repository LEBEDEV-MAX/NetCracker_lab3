package com.netCracker3.controller.specification;

import com.netCracker3.model.Customer;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Main class, which contains search rules
 */
@Component
public class CustomerSpecification {
    /**
     * This method find customer by 'equals' name in DB
     * @param name which you want to find
     * @return Specification<Customer> for findAll() method
     */
    public static Specification<Customer> findByEquals(String name){
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"), name);
            }
        };
    }

    /**
     * This method find customer by 'startWith' name in DB
     * @param name which you want to find
     * @return Specification<Customer> for findAll() method
     */
    public static Specification<Customer> findByStartWith(String name){
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), name+"%");
            }
        };
    }

    /**
     * This method find customer by 'contains' name  in DB
     * @param name which you want to find
     * @return Specification<Customer> for findAll() method
     */
    public static Specification<Customer> findByContains(String name){
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), "%"+ name +"%");
            }
        };
    }

    /**
     * This method find customer by 'like' name  in DB
     * @param name which you want to find
     * @return Specification<Customer> for findAll() method
     */
    public static Specification<Customer> findByLike(String name){
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), name);
            }
        };
    }
}
