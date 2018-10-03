package com.two.lamps.psy.web.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ROLE_SUPER_ADMIN")
public class SuperAdmin extends UserBase {

}
