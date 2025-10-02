package com.ninjaone.dundie_awards.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;
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

    @OneToMany(mappedBy="employee")
    @JsonManagedReference
    private List<DundieAward> dundieAwards;

    @ManyToOne(optional = false)
    @JoinColumn(name="organization_id", nullable=false)
    @JsonBackReference
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

    public void setDundieAwards(List<DundieAward> awards){

        this.dundieAwards = awards;
    }

    public List<DundieAward> getDundieAwards(){
        return dundieAwards;
    }
}