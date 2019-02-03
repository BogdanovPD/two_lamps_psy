package com.two.lamps.psy.web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
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

    @Column(name = "role", insertable=false, updatable=false, nullable = false)
    private String role;

    @Column(name = "phoneNumber")
    protected String phoneNumber;
    @Column(name = "email")
    protected String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBase userBase = (UserBase) o;
        return Objects.equals(surname, userBase.surname) &&
                Objects.equals(firstName, userBase.firstName) &&
                Objects.equals(patronymic, userBase.patronymic) &&
                Objects.equals(login, userBase.login) &&
                Objects.equals(phoneNumber, userBase.phoneNumber) &&
                Objects.equals(email, userBase.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, firstName, patronymic, login, phoneNumber, email);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSurnameAndInitials(){
        return String.format("%s %s.%s.", surname, firstName.substring(0, 1).toUpperCase(),
                patronymic == null || patronymic.isEmpty() ? "" :
                        patronymic.substring(0, 1).toUpperCase());
    }
}
