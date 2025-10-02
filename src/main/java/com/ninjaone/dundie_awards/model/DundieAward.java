package com.ninjaone.dundie_awards.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// TODO: Add dundie awards, associate it with employees, and add a button for awarding
// a new dundie award for the employee.
@Entity
@Table(name = "dundie_awards")
public class DundieAward {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @ManyToOne // optional because we will want awards to create but not assign them.
  @JoinColumn(name="employee_id", nullable=true)
  @JsonBackReference
  private Employee employee;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}
