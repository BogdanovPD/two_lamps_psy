package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(Client.ROLE)
public class Client extends UserBase {

    public static final String ROLE = "ROLE_CLIENT";

    @OneToMany(mappedBy = "client")
    private Set<Consultation> consultations;

    @ManyToMany(mappedBy = "clients")
    private Set<Employee> employees = new HashSet<>();

    @ManyToOne
    @PrimaryKeyJoinColumn
    private SocialNetwork socialNetwork;

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        return employees.remove(employee);
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
}
