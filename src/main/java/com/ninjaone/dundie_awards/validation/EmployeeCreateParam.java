package com.ninjaone.dundie_awards.validation;

public record EmployeeCreateParam(
    String firstName,
    String lastName,
    int dundieAwards,
    OrganizationParam organization
) {

}
