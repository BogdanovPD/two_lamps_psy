package com.two.lamps.psy.web.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(SuperAdmin.ROLE)
public class SuperAdmin extends UserBase {

    public static final String ROLE = "ROLE_SUPER_ADMIN";

}
