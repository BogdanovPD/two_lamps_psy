package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "cost", nullable = false)
    private Integer cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(name, service.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
