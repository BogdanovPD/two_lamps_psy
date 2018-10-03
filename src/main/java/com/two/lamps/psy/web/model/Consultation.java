package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Employee employee;
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Client client;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Service service;
    @Column(name = "paidSum")
    private Integer paidSum;
    @Column(name = "isFullyPaid")
    private boolean isFullyPaid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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


}
