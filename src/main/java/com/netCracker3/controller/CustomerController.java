package com.netCracker3.controller;

import com.netCracker3.controller.exceptions.CustomerNotFoundException;
import com.netCracker3.controller.exceptions.ExistCustomerException;
import com.netCracker3.controller.exceptions.WrongArgumentException;
import com.netCracker3.controller.service.CustomerService;
import com.netCracker3.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Main Controller
 */
@RestController
@RequestMapping(value = "customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService service;

    /**
     * This method returns all customers from DB
     * @return List<Customer>
     */
    @GetMapping
    public List<Customer> getAllCustomers(){
        logger.info("GetAllCustomers command executing...");
        List<Customer> customers = service.getAllCustomers();
        logger.info("Status: "+ HttpStatus.OK);
        return customers;
    }

    /**
     * This method return customer by id from DB
     * @param id of customer, which you want to get
     * @return Customer
     */
    @GetMapping(value = "{id}")
    public Customer getCustomer(@PathVariable("id") int id) throws CustomerNotFoundException{
        logger.info("GetCustomer command executing with id="+ id);
        try {
            return service.getCustomer(id);
        }
        catch (CustomerNotFoundException e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * This method add new customer in DB
     * @param customer , which you want to add
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@Valid @RequestBody Customer customer) throws ExistCustomerException{
        logger.info("CreateCustomer command executing with arguments:");
        logger.info("id="+ customer.getId() +
                    ",name="+customer.getName() +
                    ",phone="+ customer.getPhone() +
                    ",address="+ customer.getAddress());
        try{
            service.createCustomer(customer);
            logger.info(HttpStatus.CREATED.toString());
        }
        catch (ExistCustomerException e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * This method delete customer by id in DB
     * @param id of customer, which you want to delete
     * @throws CustomerNotFoundException if customer not found by id
     */
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") int id) throws CustomerNotFoundException{
        logger.info("DeleteCustomer command executing with id="+ id);
        try{
            service.deleteCustomer(id);
            logger.info(HttpStatus.OK.toString());
        }
        catch (CustomerNotFoundException e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * This method delete all customers in DB
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllCustomers(){
        logger.info("DeleteAllCustomers command executing...");
        service.deleteAllCustomers();
        logger.info(HttpStatus.OK.toString());
    }

    /**
     * This method update customer by id in DB
     * @param id of customer, which you want to update
     * @param name is new name
     * @param phone is new phone
     * @param address is new address
     */
    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "phone", required = false) String phone,
                       @RequestParam(value = "address", required = false) String address) throws CustomerNotFoundException{
        logger.info("UpdateCustomer command executing with arguments: ");
        logger.info("id="+ id +",name="+ name +",phone="+ phone +",address="+ address);

        try{
            service.updateCustomer(id, name, phone, address);
            logger.info(HttpStatus.OK.toString());
        }
        catch (CustomerNotFoundException e){
            logger.error(e.getMessage());
            throw e;
        }
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
    @GetMapping(value = "find")
    public List<Customer> findCustomer(@RequestParam("name") String name,
                                       @RequestParam("operation") String operation) throws WrongArgumentException {
        logger.info("FindCustomer command executing with arguments:");
        logger.info("name="+ name + ",operation="+ operation);
        try{
            List<Customer> customers = service.findCustomer(name, operation);
            logger.info(HttpStatus.OK.toString());
            return customers;
        }
        catch (WrongArgumentException e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
