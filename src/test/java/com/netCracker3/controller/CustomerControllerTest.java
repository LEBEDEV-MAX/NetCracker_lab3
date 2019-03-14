package com.netCracker3.controller;

import com.netCracker3.controller.repository.CustomerRepository;
import com.netCracker3.model.Customer;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
/*    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private CustomerRepository repository;

    @After
    public void resetDb() {
        repository.deleteAll();
        repository.flush();
    }

    public Customer createTestCustomer(int id){
        Customer customer = new Customer(id,"name","phone","address");
        return repository.saveAndFlush(customer);
    }

    @Test
    public void getAllCustomers() {
        createTestCustomer(1);
        createTestCustomer(2);
        ResponseEntity<List<Customer>> responseEntity
                = testRestTemplate.exchange("/customers", HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Customer>>(){});

        List<Customer> customerList = responseEntity.getBody();
        //test
        assertThat(customerList.size(), is(2));
        assertThat(customerList.get(1).getName(), is("NAME"));
        assertThat(customerList.get(1).getPhone(), is("PHONE"));
        assertThat(customerList.get(1).getAddress(), is("ADDRESS"));
    }

    @Test
    public void getCustomer() {
        int id = createTestCustomer(1).getId();
        Customer customer = testRestTemplate.getForObject("/customers/{id}", Customer.class, id);

        assertThat(customer.getId(), is(1));
        assertThat(customer.getName(), is("NAME"));
        assertThat(customer.getPhone(), is("PHONE"));
        assertThat(customer.getAddress(), is("ADDRESS"));
    }

    @Test
    public void createCustomer() {
        Customer customer = new Customer(1,"name","phone","address");

        ResponseEntity<Customer> responseEntity =
                testRestTemplate.postForEntity("/customers", customer, Customer.class);

        //test
        assertThat(repository.findAll().size(), is(1));
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));

        Customer customer1 = testRestTemplate.getForObject("/customers/{id}", Customer.class, 1);
        assertThat(customer1.getId(), is(1));
        assertThat(customer1.getName(), is("NAME"));
        assertThat(customer1.getPhone(), is("PHONE"));
        assertThat(customer1.getAddress(), is("ADDRESS"));
    }

    @Test
    public void deleteCustomer() {
        createTestCustomer(1);
        Customer customer2 = createTestCustomer(2);
        testRestTemplate.delete("/customers/{id}",1);

        assertThat(repository.findAll().size(), is(1));
        Customer customer = testRestTemplate.getForObject("/customers/{id}", Customer.class, 2);
        assertThat(customer.getName(), is(customer2.getName()));
        assertThat(customer.getPhone(), is(customer2.getPhone()));
        assertThat(customer.getAddress(), is(customer2.getAddress()));
    }

    @Test
    public void deleteAllCustomers() {
        createTestCustomer(1);
        createTestCustomer(2);
        testRestTemplate.delete("/customers");

        assertThat(repository.findAll().size(), is(0));
    }

    @Test
    public void update() {
        int id = createTestCustomer(1).getId();
        Map<String, String> map = new HashMap<>();
        map.put("name","aa");
        map.put("phone", "123");
        map.put("address","bb");

        testRestTemplate.put("/customers/{id}", map, id);

        Customer customer = testRestTemplate.getForObject("/customers/{id}", Customer.class, 1);
        assertThat(customer.getName(), is("AA"));
        assertThat(customer.getPhone(), is("123"));
        assertThat(customer.getAddress(), is("BB"));
    }

    @Test
    public void findCustomerByEquals() {
        createTestCustomer(1);
        Map<String, String> map = new HashMap<>();
        map.put("name","name");
        map.put("operation", "equals");

        //find(map);
    }

    @Test
    public void findCustomerByContains() {
        Map<String, String> map = new HashMap<>();
        map.put("name","me");
        map.put("operation", "contains");

        //find(map);
    }

    @Test
    public void findCustomerByStartWith() {
        Map<String, String> map = new HashMap<>();
        map.put("name","na");
        map.put("operation", "startWith");

        //find(map);
    }

    @Test
    public void findCustomerByLike() {
        Map<String, String> map = new HashMap<>();
        map.put("name","n?m*");
        map.put("operation", "like");

        //find(map);
    }

    private void find(Map<String, String> map){
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map);
        ResponseEntity<List<Customer>> responseEntity
                = testRestTemplate.exchange("/customers/find", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Customer>>(){});

        List<Customer> customerList = responseEntity.getBody();
        //test
        assertThat(customerList.get(1).getId(), is(1));
        assertThat(customerList.get(1).getName(), is("name"));
        assertThat(customerList.get(1).getPhone(), is("phone"));
        assertThat(customerList.get(1).getAddress(), is("address"));
    }
*/
}

