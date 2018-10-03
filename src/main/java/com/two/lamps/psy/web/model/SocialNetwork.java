package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.util.Objects;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SocialNetworkType getType() {
        return type;
    }

    public void setType(SocialNetworkType type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialNetwork that = (SocialNetwork) o;
        return Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }
}
