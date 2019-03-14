package com.netCracker3.controller.service;

import com.netCracker3.controller.exceptions.CustomerNotFoundException;
import com.netCracker3.controller.exceptions.ExistCustomerException;
import com.netCracker3.controller.exceptions.WrongArgumentException;
import com.netCracker3.model.Customer;

import java.util.List;

/**
 * This interface is service of customer's DB
 */
public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomer(int id) throws CustomerNotFoundException;
    void createCustomer(Customer customer) throws ExistCustomerException;
    void deleteCustomer(int id) throws CustomerNotFoundException;
    void deleteAllCustomers();
    void updateCustomer(int id, String name, String phone, String address) throws CustomerNotFoundException;
    List<Customer> findCustomer(String name, String operation) throws WrongArgumentException;
}
