package com.two.lamps.psy.web.repository;

import com.two.lamps.psy.web.model.Client;
import com.two.lamps.psy.web.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
