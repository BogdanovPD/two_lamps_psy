package com.two.lamps.psy.web.model;

import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "ROLE_CLIENT")
public class Client extends UserBase {

}
