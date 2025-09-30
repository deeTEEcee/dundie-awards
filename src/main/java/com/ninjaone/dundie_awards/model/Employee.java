package com.ninjaone.dundie_awards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
//import jakarta.persistence.Index;
//import jakarta.persistence.Table;

@Entity
@Table(name = "employees", indexes= {
    @Index(name = "unique_index", columnList="firstName, lastName", unique=true)
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @JsonProperty("first_name")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "dundie_awards")
    private Integer dundieAwards;

    @ManyToOne(optional = false)
    private Organization organization;

    public Employee() {

    }

    public Employee(String firstName, String lastName, Organization organization) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setDundieAwards(int dundieAwards){
        this.dundieAwards = dundieAwards;
    }

    public Integer getDundieAwards(){
        return dundieAwards;
    }
}