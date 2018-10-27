package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(Employee.ROLE)
public class Employee extends UserBase {

    public static final String ROLE = "ROLE_EMPLOYEE";

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Position position;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "employee_client",
            joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Consultation> consultations;

    public boolean addClient(Client client) {
        return clients.add(client);
    }

    public boolean removeClient(Client client) {
        return clients.remove(client);
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }
}
