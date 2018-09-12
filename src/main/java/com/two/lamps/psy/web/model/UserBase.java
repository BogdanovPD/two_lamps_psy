package com.two.lamps.psy.web.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"id", "password"})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class UserBase {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "surname", nullable = false)
    protected String surname;
    @Column(name = "firstName", nullable = false)
    protected String firstName;
    @Column(name = "patronymic")
    protected String patronymic;

    @Column(name = "login", nullable = false, unique = true)
    protected String login;
    @Column(name = "password", nullable = false)
    protected String password;

    @Column(name = "phoneNumber")
    protected String phoneNumber;
    @Column(name = "email")
    protected String email;



}
