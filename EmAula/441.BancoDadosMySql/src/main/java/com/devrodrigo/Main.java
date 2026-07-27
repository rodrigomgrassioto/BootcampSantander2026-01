package com.devrodrigo;

import com.devrodrigo.persistence.EmployeeDAO;
import com.devrodrigo.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {
    static void main(){
        final var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/bcsantander_441aula","root","")
                .load();
        flyway.migrate();

//        final var employeeDAO = new EmployeeDAO();
//        final var employee = new EmployeeEntity();
//        employee.setId(5);
//        employee.setName("Kiki 4");
//        employee.setSalary(new BigDecimal("10.00"));
//        employee.setBirthday(OffsetDateTime.now().minusYears(19));
//        System.out.print(employee);
//        employeeDAO.insert(employee);
//        employeeDAO.update(employee);
//        System.out.print(employee);
//        employeeDAO.findAll().forEach(System.out::println);
//        employeeDAO.delete(5);
    }
}