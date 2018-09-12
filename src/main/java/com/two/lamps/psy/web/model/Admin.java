package com.two.lamps.psy.web.model;

import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "ROLE_ADMIN")
public class Admin extends UserBase {

}
