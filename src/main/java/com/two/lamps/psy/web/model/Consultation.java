package com.two.lamps.psy.web.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(exclude = {"id", "paidSum", "isFullyPaid"})
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

}
