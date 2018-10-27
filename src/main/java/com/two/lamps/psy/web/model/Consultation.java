package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Employee employee;
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Client client;
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Service service;
    @Column(name = "paidSum")
    private Integer paidSum = 0;
    @Column(name = "isFullyPaid")
    private boolean isFullyPaid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        if (employee != null && client != null) {
            employee.addClient(client);
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        if (client != null && employee != null) {
            client.addEmployee(employee);
        }
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getPaidSum() {
        return paidSum;
    }

    public void setPaidSum(Integer paidSum) {
        this.paidSum = paidSum;
    }

    public boolean isFullyPaid() {
        return isFullyPaid;
    }

    public void setFullyPaid(boolean fullyPaid) {
        isFullyPaid = fullyPaid;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
