package com.netCracker3.controller.service;

import com.netCracker3.controller.exceptions.CustomerNotFoundException;
import com.netCracker3.controller.exceptions.ExistCustomerException;
import com.netCracker3.controller.exceptions.WrongArgumentException;
import com.netCracker3.controller.repository.CustomerRepository;
import com.netCracker3.controller.specification.CustomerSpecification;
import com.netCracker3.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplCustomerService implements CustomerService {
    @Autowired
    private CustomerRepository customersDAO;

    /**
     * This method returns all customers from DB
     * @return List<Customer>
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customersDAO.findAll();
    }

    /**
     * This method return customer by id from DB
     * @param id of customer, which you want to get
     * @return Customer
     */
    @Override
    public Customer getCustomer(int id) throws CustomerNotFoundException{
        Optional<Customer> optional = customersDAO.findById(id);
        if(optional.isPresent()) return optional.get();
        else throw new CustomerNotFoundException(id);
    }

    /**
     * This method add new customer in DB
     * @param customer , which you want to add
     */
    @Override
    public void createCustomer(Customer customer) throws ExistCustomerException{
        Optional<Customer> optional = customersDAO.findById(customer.getId());
        if(optional.isPresent()) throw new ExistCustomerException(customer.getId());
        else customersDAO.save(customer);
    }

    /**
     * This method delete customer by id in DB
     * @param id of customer, which you want to delete
     * @throws CustomerNotFoundException if customer not found by id
     */
    @Override
    public void deleteCustomer(int id) throws CustomerNotFoundException{
        Customer customer = getCustomer(id);
        customersDAO.delete(customer);
    }

    /**
     * This method delete all customers in DB
     */
    @Override
    public void deleteAllCustomers() {
        customersDAO.deleteAll();
    }

    /**
     * This method update customer by id in DB
     * @param id of customer, which you want to update
     * @param name is new name
     * @param phone is new phone
     * @param address is new address
     */
    @Override
    public void updateCustomer(int id, String name, String phone, String address) throws CustomerNotFoundException{
        Customer customer = getCustomer(id);

        if(name != null) customer.setName(name);
        if(phone != null) customer.setPhone(phone);
        if(address != null) customer.setAddress(address);

        customersDAO.save(customer);
    }

    /**
     * This method find customer by his name and operation
     * operation - search principle; contains arguments: equals | contains | startWith; like
     * equals - will find customer by full name match
     * contains - will find customer if his name contains 'name' argument
     * startWith - will find customer if his name start with 'name' argument
     * like - will find customer if it matches the pattern (pattern = 'name' argument)
     * @param name of customer , which you want to find
     * @param operation is search principle
     * @return List<Customer> : found customers
     * @throws WrongArgumentException , if user write wrong 'operation' argument
     */
    @Override
    public List<Customer> findCustomer(String name, String operation) throws WrongArgumentException{
        name = name.toUpperCase();
        operation = operation.toLowerCase();
        List<Customer> customers;

        switch (operation){
            case "equals":
                customers = customersDAO.findAll(CustomerSpecification.findByEquals(name));
                break;
            case "contains":
                customers = customersDAO.findAll(CustomerSpecification.findByContains(name));
                break;
            case "startwith":
                customers = customersDAO.findAll(CustomerSpecification.findByStartWith(name));
                break;
            case "like":
                name = getPattern(name);
                customers = customersDAO.findAll(CustomerSpecification.findByLike(name));
                break;
            default:
                throw new WrongArgumentException("Argument operation="+ operation +" is wrong");
        }
        return customers;
    }


    /**
     * This method return pattern for 'findByNameLike' command
     * @param name - pattern
     * @return String name
     */
    private static String getPattern(String name){
        //create regular expression: replace all ? on _ (single character) and all * on % (many characters)
        name = name.replaceAll("\\?", "_");
        return name.replaceAll("\\*", "%");
    }
}
