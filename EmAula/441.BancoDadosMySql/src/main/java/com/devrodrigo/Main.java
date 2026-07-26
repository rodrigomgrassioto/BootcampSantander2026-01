package com.devrodrigo;

import com.devrodrigo.persistence.EmployeeDAO;
import com.devrodrigo.persistence.entity.EmployeeEntity;
//import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {
    static void main(){
//        final var flyway = Flyway.configure()
//                .dataSource("jdbc:mysql://localhost:3306/bcsantander_441aula","root","")
//                .load();
//        flyway.migrate();

        final var employeeDAO = new EmployeeDAO();
//        final var employee = new EmployeeEntity();
//        employee.setName("Kiki");
//        employee.setSalary(new BigDecimal("0.00"));
//        employee.setBirthday(OffsetDateTime.now().minusYears(6));
//        System.out.print(employee);
//        employeeDAO.insert(employee);
//        System.out.print(employee);
        employeeDAO.findAll().forEach(System.out::println);
    }
}