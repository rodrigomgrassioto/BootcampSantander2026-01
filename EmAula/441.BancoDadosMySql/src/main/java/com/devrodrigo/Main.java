package com.devrodrigo;

import com.devrodrigo.persistence.ContactDAO;
import com.devrodrigo.persistence.EmployeeDAO;
import com.devrodrigo.persistence.entity.ContactEntity;
import com.devrodrigo.persistence.entity.EmployeeEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class Main {
    private final static Faker faker = new Faker(Locale.of("pr", "BR"));
    static void main(){
        final var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/bcsantander_441aula","root","")
                .load();
        flyway.migrate();

        final var employeeDAO = new EmployeeDAO();
        final var contactDAO = new ContactDAO();
        final var employee = new EmployeeEntity();
//        employee.setId(7);
//        employee.setName("Carla");
//        employee.setSalary(new BigDecimal("10000.00"));
//        employee.setBirthday(OffsetDateTime.now().minusYears(44));
//        employeeDAO.insert(employee);
//        System.out.print(employee);
//        employeeDAO.update(employee);
//        System.out.print(employee);
        System.out.print(employeeDAO.findById(3));
//        employeeDAO.findAll().forEach(System.out::println);
//        employeeDAO.delete(7);

        // insert contato
//        final var contact = new ContactEntity();
//        contact.setDescription("carla@gmail.com");
//        contact.setType("e-mail");
//        contact.setEmployee(employee);
//        contactDAO.insert(contact);
//
//        final var contact2 = new ContactEntity();
//        contact2.setDescription("1234567890");
//        contact2.setType("celular");
//        contact2.setEmployee(employee);
//        contactDAO.insert(contact2);

        // gerando dodos fakes
//        final var entities = Stream.generate(() -> {
//            final var employee = new EmployeeEntity();
//            employee.setName(faker.name().fullName());
//            employee.setSalary(new BigDecimal(faker.number().digits(4)));
//            employee.setBirthday(OffsetDateTime.of(faker.date().birthdayLocalDate(3, 80), LocalTime.MIN, UTC));
//            employee.setBirthday(OffsetDateTime.of(faker.date().birthdayLocalDate(3, 80), LocalTime.MIN.withNano(0), UTC));

            // Gera idades entre 3 e 55 anos (nascidos de 1971 em diante)
//            employee.setBirthday(OffsetDateTime.of(faker.date().birthdayLocalDate(3, 55), LocalTime.MIN.withNano(0), UTC));
            // Usa a nova API timeAndDate() e o método birthdayLocalDate()
//            LocalDate birthdayDate = faker.timeAndDate().birthday(3, 55);
//            employee.setBirthday(OffsetDateTime.of(birthdayDate, LocalTime.MIN.withNano(0), UTC));
//
//            return employee;
//        }).limit(4000).toList();
//
//        employeeDAO.insertBatch(entities);
    }
}