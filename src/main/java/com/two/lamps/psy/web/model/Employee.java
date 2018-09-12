package com.two.lamps.psy.web.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "ROLE_EMPLOYEE")
public class Employee extends UserBase {

    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Position position;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "employee_client",
            joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients;

}
