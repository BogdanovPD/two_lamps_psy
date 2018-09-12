package com.two.lamps.psy.web.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Service service;
    @Column(name = "number", nullable = false)
    private Integer number;

}
