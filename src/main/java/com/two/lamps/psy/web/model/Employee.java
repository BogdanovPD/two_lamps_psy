package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }
}
