package com.two.lamps.psy.web.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "social_networks")
public class SocialNetwork {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn
    private SocialNetworkType type;
    @Column(name = "reference", nullable = false)
    private String reference;

}
