package com.two.lamps.psy.web.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(exclude = {"id", "password"})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class UserBase {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter protected long id;

    @Column(name = "surname", nullable = false)
    @Getter @Setter protected String surname;

    @Column(name = "firstName", nullable = false)
    @Getter @Setter protected String firstName;
    @Column(name = "patronymic")
    @Getter @Setter protected String patronymic;

    @Column(name = "login", nullable = false, unique = true)
    @Getter @Setter protected String login;
    @Column(name = "password", nullable = false)
    @Getter @Setter protected String password;

    @Column(name = "phoneNumber")
    @Getter @Setter protected String phoneNumber;
    @Column(name = "email")
    @Getter @Setter protected String email;

}
