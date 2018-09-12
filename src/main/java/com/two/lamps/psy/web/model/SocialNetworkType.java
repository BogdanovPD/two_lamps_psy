package com.two.lamps.psy.web.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "social_network_type")
public class SocialNetworkType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
