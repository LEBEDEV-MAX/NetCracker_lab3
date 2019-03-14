package com.netCracker3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * This class stores data of customers
 */
@Entity
@Table(name = "customer")
public class Customer{
    @Id
    @Column(name = "id")
    @Min(1)
    @NotNull
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "address")
    @NotNull
    private String address;

    public Customer(){
    }

    public Customer(int id, String name, String phone, String address) {
        this.id = id;
        this.name = name.toUpperCase();
        this.phone = phone.toUpperCase();
        this.address = address.toUpperCase();
    }

    /**
     * Writes the value of id
     * @param id customer's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Writes the value of name
     *
     * @param name customer's name
     */
    public synchronized void setName(String name) {
        this.name = name.toUpperCase();
    }

    /**
     * Writes the value of phone
     * @param phone customer's phone
     */
    public synchronized void setPhone(String phone) {
        this.phone = phone.toUpperCase();
    }

    /**
     * Writes the value of address
     * @param address customer's address
     */
    public synchronized void setAddress(String address) {
        this.address = address.toUpperCase();
    }

    /**
     * Get value of customer's id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Get value of customer's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get value of customer's phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get value of customer's address
     * @return address
     */
    public String getAddress() {
        return address;
    }
}
