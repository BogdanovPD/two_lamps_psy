package com.two.lamps.psy.web.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(Admin.ROLE)
public class Admin extends UserBase {

    public static final String ROLE = "ROLE_ADMIN";

}
